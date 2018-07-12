package me.vukas;

import me.vukas.dto.Leader;
import org.rapidoid.annotation.Controller;
import org.rapidoid.annotation.GET;

@Controller
public class ElectorController {
    @GET("/")
    public Leader leader(){
        return new Leader("nesto");
    }
}
