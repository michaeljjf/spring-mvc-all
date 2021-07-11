package com.jjf.service.impl;

import com.jjf.mapper.PlayerMapper;
import com.jjf.pojo.Player;
import com.jjf.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    public int addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }

    public List<Player> findAll() {
        return playerMapper.findAll();
    }
}
