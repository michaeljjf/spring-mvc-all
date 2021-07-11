package com.jjf.controller;

import com.jjf.pojo.Player;
import com.jjf.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("addPlayer.do")
    public String addPlayer(Player player) {
        System.out.println(player);
        playerService.addPlayer(player);
        return "redirect:/playerList.jsp";
    }

    @ResponseBody
    @RequestMapping("findAllPlayer.do")
    public List<Player> findAllPlayer() {
        return playerService.findAll();
    }
}
