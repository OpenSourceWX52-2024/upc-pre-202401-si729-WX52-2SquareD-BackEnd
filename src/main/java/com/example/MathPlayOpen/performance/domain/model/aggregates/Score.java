package com.example.MathPlayOpen.performance.domain.model.aggregates;

import com.example.MathPlayOpen.performance.domain.model.commands.CreateScoreCommand;
import com.example.MathPlayOpen.performance.domain.model.entities.Participant;
import com.example.MathPlayOpen.performance.domain.model.valueobjects.Amount;
import com.example.MathPlayOpen.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class Score extends AuditableAbstractAggregateRoot<Score> {

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @Embedded
    private Amount amount;

    protected Score() {}

    public Score(CreateScoreCommand command) {
        this();
        this.participant = new Participant(command.participantId().toString());
        this.amount = new Amount(command.amount());
    }

    public Integer getAmount() {
        return amount.amount();
    }
}
