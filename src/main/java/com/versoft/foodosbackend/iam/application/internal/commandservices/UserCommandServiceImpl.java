package com.versoft.foodosbackend.iam.application.internal.commandservices;





import com.versoft.foodosbackend.Inventory.Application.Internal.Outboundservices.acl.ExternalProfileService;
import com.versoft.foodosbackend.iam.application.internal.outboundservices.acl.ExternalInventoryService;
import com.versoft.foodosbackend.iam.application.internal.outboundservices.acl.ExternalProfileServiceToUser;
import com.versoft.foodosbackend.iam.application.internal.outboundservices.hashing.HashingService;
import com.versoft.foodosbackend.iam.application.internal.outboundservices.tokens.TokenService;
import com.versoft.foodosbackend.iam.domain.model.aggregates.User;
import com.versoft.foodosbackend.iam.domain.model.commands.SignInCommand;
import com.versoft.foodosbackend.iam.domain.model.commands.SignUpCommand;
import com.versoft.foodosbackend.iam.domain.services.UserCommandService;
import com.versoft.foodosbackend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.versoft.foodosbackend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User command service implementation
 * <p>
 *     This class implements the {@link UserCommandService} interface and provides the implementation for the
 *     {@link SignInCommand} and {@link SignUpCommand} commands.
 * </p>
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;


    private final RoleRepository roleRepository;
    private final ExternalProfileServiceToUser externalProfileServiceToUser;
    private final ExternalInventoryService externalInventoryService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, ExternalProfileServiceToUser profileServiceToUser, RoleRepository roleRepository, ExternalProfileServiceToUser externalProfileServiceToUser, ExternalInventoryService externalInventoryService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;

        this.roleRepository = roleRepository;
        this.externalProfileServiceToUser = externalProfileServiceToUser;

        this.externalInventoryService = externalInventoryService;
    }

    /**
     * Handle the sign-in command
     * <p>
     *     This method handles the {@link SignInCommand} command and returns the user and the token.
     * </p>
     * @param command the sign-in command containing the username and password
     * @return and optional containing the user matching the username and the generated token
     * @throws RuntimeException if the user is not found or the password is invalid
     */
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    /**
     * Handle the sign-up command
     * <p>
     *     This method handles the {@link SignUpCommand} command and returns the user.
     * </p>
     * @param command the sign-up command containing the username and password
     * @return the created user
     */
    @Override
    public Optional<User> handle(SignUpCommand command) {

        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");

        var roleQuery = roleRepository.findByName(command.role().getName());

        if(roleQuery.isEmpty()) throw new RuntimeException("Role name not found");

        var profileId = externalProfileServiceToUser.createProfile(
                command.imageProfile(), command.firstName(), command.email(), command.lastName());

        externalInventoryService.createInventory(command.email());





        var user = new User(command.username(), hashingService.encode(
                command.password()), command.role(),profileId.get());
        System.out.println(user);

        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }
}