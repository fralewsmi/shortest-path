package fralewsmi.shortestpath.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fralewsmi.shortestpath.server.calculator.Dijkstra;
import fralewsmi.shortestpath.server.calculator.ShortestPathAlgorithm;
import fralewsmi.shortestpath.server.calculator.model.Graph;
import fralewsmi.shortestpath.server.calculator.model.Node;
import fralewsmi.shortestpath.server.model.Network;
import fralewsmi.shortestpath.server.model.RailNetwork;
import fralewsmi.shortestpath.server.model.Route;
import fralewsmi.shortestpath.server.model.Station;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-05T11:23:54.670-08:00")

@Controller
public class RouteApiController implements RouteApi {

    private static final Logger log = LoggerFactory.getLogger(RouteApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private Network network;
    private ShortestPathAlgorithm shortestPathAlgorithm;

    @org.springframework.beans.factory.annotation.Autowired
    public RouteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Route> routeGet(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "origin", required = true) final String origin, @NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "destination", required = true) String destination) {
        if (origin == null || destination == null) {
            return new ResponseEntity<Route>(HttpStatus.BAD_REQUEST);
        } else {
            network = new RailNetwork();
            Graph networkGraph = network.createGraph();
            Node originNode = networkGraph.getNodes().stream().filter(node -> node.getName().equals(origin)).findFirst().orElse(null);
            if (originNode == null) {
                return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
            }
            shortestPathAlgorithm = new Dijkstra();
            Graph shortestPathGraph = shortestPathAlgorithm.calculateShortestPathFromSource(networkGraph, originNode);
            Node destinationNode = shortestPathGraph.getNodes().stream().filter(node -> node.getName().equals(destination)).findFirst().orElse(null);
            if (destinationNode == null) {
                return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
            } else {
                Route route = new Route();
                destinationNode.getShortestPath().forEach((node -> {
                    route.addStationsItem(new Station().name(node.getName()));
                }));
                return new ResponseEntity<Route>((route), HttpStatus.OK);
            }
        }
    }
}