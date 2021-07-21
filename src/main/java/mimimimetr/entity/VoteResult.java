package mimimimetr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class VoteResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cat", referencedColumnName = "cat_id")
    private Cat cat;
    private Long numberVotes;

    public VoteResult() {
    }

    public VoteResult(Cat cat, Long numberVotes) {
        this.cat = cat;
        this.numberVotes = numberVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Long getNumberVotes() {
        return numberVotes;
    }

    public void setNumberVotes(Long numberVotes) {
        this.numberVotes = numberVotes;
    }

}
