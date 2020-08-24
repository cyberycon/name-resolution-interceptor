package io.thekelly.resolver.controller;

import java.net.InetAddress;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 

@Controller
@RequestMapping("/") 
public class SimpleController { 
    
    @GetMapping()
    public ResponseEntity<String> index() {

        return ResponseEntity.ok("OK"); 

    }

    @GetMapping("/{host}")
    public ResponseEntity<String> resolve(@PathVariable("host") String host) {

        try {
            InetAddress ip = InetAddress.getByName(host) ;
            return ResponseEntity.ok(ip.toString()) ; 
        }
        catch (Exception e) {
            String message = String.format("Unresolvable host %s", e.getMessage()) ; 
            return ResponseEntity.ok(message); 
        }
  }
}
