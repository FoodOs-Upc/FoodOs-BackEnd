package com.versoft.foodosbackend.Task.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Task.Domain.Model.Commands.CreateTaskCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "Task")
public class Task extends AbstractAggregateRoot<Task> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String title;

    @Getter
    private String description;

    @Getter
    private String date;

    @Getter
    private String memberasignado;

    public Task() {
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.date = Strings.EMPTY;
        this.memberasignado = Strings.EMPTY;
    }

    public Task(String title, String description, String date, String memberasignado) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.memberasignado = memberasignado;
    }
    public Task (CreateTaskCommand command)
    {
        this();
        this.title = command.title();
        this.description = command.description();
        this.date = command.date();
        this.memberasignado = command.memberasignado();
    }

    public Task updateTaskCommand (String title, String description, String date, String memberasignado){
        this.title = title;
        this.description = description;
        this.date = date;
        this.memberasignado = memberasignado;
        return this;
    }


}
