package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/getPort")
    public InetAddress getPort() throws UnknownHostException {
        return infoService.getPort();
    }
}
