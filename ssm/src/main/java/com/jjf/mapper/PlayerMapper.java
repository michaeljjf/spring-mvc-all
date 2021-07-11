package com.jjf.mapper;

import com.jjf.pojo.Player;

import java.util.List;

public interface PlayerMapper {

    int addPlayer(Player player);

    List<Player> findAll();
}
