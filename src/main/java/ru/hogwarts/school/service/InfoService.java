package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class InfoService {
    public InfoService() {
    }

    public InetAddress getPort() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }
}
