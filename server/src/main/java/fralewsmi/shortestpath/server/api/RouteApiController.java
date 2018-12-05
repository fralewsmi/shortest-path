package fralewsmi.shortestpath.server.api;

import fralewsmi.shortestpath.server.model.Network;
import fralewsmi.shortestpath.server.model.RailNetwork;
import fralewsmi.shortestpath.server.model.Route;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-05T11:23:54.670-08:00")

@Controller
public class RouteApiController implements RouteApi {

    private static final Logger log = LoggerFactory.getLogger(RouteApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private Network network;

    @org.springframework.beans.factory.annotation.Autowired
    public RouteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Route> routeGet(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "origin", required = true) String origin,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "destination", required = true) String destination) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Route>(objectMapper.readValue("{  \"stations\" : [ {    \"name\" : \"name\"  }, {    \"name\" : \"name\"  } ]}", Route.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Route>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Route>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostConstruct
    public void init() {
        network = new RailNetwork();
        network.create();
    }

}
