package mimimimetr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserVotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usr", referencedColumnName = "usr_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cat_couple", referencedColumnName = "cat_couple_id")
    private CatCouple catCouple;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatCouple getCatCouple() {
        return catCouple;
    }

    public void setCatCouple(CatCouple catCouple) {
        this.catCouple = catCouple;
    }

    public UserVotes(User user, CatCouple catCouple) {
        this.user = user;
        this.catCouple = catCouple;
    }

    public UserVotes() {
    }

}
