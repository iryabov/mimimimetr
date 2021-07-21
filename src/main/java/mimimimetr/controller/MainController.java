package mimimimetr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mimimimetr.entity.Cat;
import mimimimetr.entity.CatCouple;
import mimimimetr.entity.User;
import mimimimetr.entity.UserVotes;
import mimimimetr.service.CatCoupleService;
import mimimimetr.service.CatService;
import mimimimetr.service.UserService;
import mimimimetr.service.UserVotesService;
import mimimimetr.service.VoteResultService;


@Controller
public class MainController {

    @Autowired
    private CatCoupleService catCoupleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CatService catService;

    @Autowired
    private UserVotesService userVotesService;

    @Autowired
    private VoteResultService voteResultService;

    @GetMapping("/mimimimetr")
    public String getMimimimetrPage(Authentication authentication, Model model) {
        String username = authentication.getName();
        Long userId = userService.findByUsername(username).getId();

        model.addAttribute("catCouples", catCoupleService.getAvailableList(userId));

        return "main";
    }

    @PostMapping("/mimimimetr/save-vote")
    @ResponseBody
    public ResponseEntity<String> saveVoteItem(@RequestParam(value = "winnerCatId", required = false) Long winnerCatId,
                                               @RequestParam(value = "catCoupleId", required = false) Long catCoupleId, 
                                               Authentication authentication) {

        Optional<Cat> catOpt = catService.getById(winnerCatId);
        Optional<CatCouple> catCoupleOpt = catCoupleService.findById(catCoupleId);
        String username = authentication.getName();

        User user = userService.findByUsername(username);
        userVotesService.save(new UserVotes(user, catCoupleOpt.get()));
        voteResultService.update(winnerCatId);

        return ResponseEntity.ok("Голос был сохранён");

    }
    
    @GetMapping("/mimimimetr/top")
    public String getTopCats(Model model) {
        model.addAttribute("voteResults", voteResultService.getAll());
        
        return "top-cats";
    }

}
