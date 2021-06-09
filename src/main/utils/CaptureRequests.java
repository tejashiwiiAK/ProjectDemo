package main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Optional;

public class CaptureRequests {
    DevTools devTools;

    public void captureHttpRequests(WebDriver driver , String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            devTools =((ChromeDriver)driver).getDevTools();
        }  else if(browserName.equalsIgnoreCase("firefox")) {
        } else if(browserName.equalsIgnoreCase("edge")) {
            devTools = ((EdgeDriver) driver).getDevTools();
        }

        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                entry->{
                System.out.println("Request URL  is :" + entry.getRequest().getUrl());
                    System.out.println("Request type  is :" +entry.getRequest().getMethod());
                });

       }

    }

