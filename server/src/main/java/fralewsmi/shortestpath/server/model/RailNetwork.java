package fralewsmi.shortestpath.server.model;

import fralewsmi.shortestpath.server.calculator.Dijkstra;
import fralewsmi.shortestpath.server.calculator.ShortestPathAlgorithm;
import fralewsmi.shortestpath.server.calculator.model.Graph;
import fralewsmi.shortestpath.server.calculator.model.Node;

public class RailNetwork implements Network {
    @Override
    public void create() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        ShortestPathAlgorithm shortestPathAlgorithm = new Dijkstra();
        graph = shortestPathAlgorithm.calculateShortestPathFromSource(graph, nodeA);
    }
}
