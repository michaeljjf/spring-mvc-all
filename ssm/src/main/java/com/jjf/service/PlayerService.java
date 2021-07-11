package com.jjf.service;

import com.jjf.pojo.Player;

import java.util.List;

public interface PlayerService {
    int addPlayer(Player player);

    List<Player> findAll();
}
