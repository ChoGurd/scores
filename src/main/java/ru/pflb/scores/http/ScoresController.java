package ru.pflb.scores.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pflb.scores.dto.Score;
import ru.pflb.scores.service.ScoreService;

@RestController
public class ScoresController {


    private final ScoreService scoreService;

    @Autowired // не обязательно
    public ScoresController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    @GetMapping(path = "/hiscores/{levelId}")
    //TODO implement
    public String getHighScores(@PathVariable int levelId) {
        return scoreService.highScores(levelId);
    }


    @PostMapping(path = "/score/{levelId}/{userId}")
    //TODO implement; pass sessionKey as Query Param (/.../../..?session={sessionKey})
    public void postRecord(@PathVariable int levelId, @PathVariable int userId, @RequestParam("session") String sessionKey, @RequestBody String score)
    {
        scoreService.record(sessionKey, Integer.parseInt(score), levelId);
    }
}
