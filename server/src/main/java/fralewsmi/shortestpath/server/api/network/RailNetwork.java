package fralewsmi.shortestpath.server.api.network;

import fralewsmi.shortestpath.server.calculator.model.Graph;
import fralewsmi.shortestpath.server.calculator.model.Node;

public class RailNetwork implements Network {

    private Graph graph;

    @Override
    public Graph createGraph() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");

        nodeA.addDestination(nodeB, 12);
        nodeA.addDestination(nodeD, 19);
        nodeA.addDestination(nodeE, 20);
        nodeA.addDestination(nodeG, 16);

        nodeB.addDestination(nodeC, 5);
        nodeB.addDestination(nodeD, 13);
        nodeB.addDestination(nodeI, 15);

        nodeC.addDestination(nodeD, 5);

        nodeD.addDestination(nodeE, 7);

        nodeE.addDestination(nodeF, 5);

        nodeF.addDestination(nodeA, 5);

        nodeG.addDestination(nodeF, 11);

        nodeH.addDestination(nodeA, 4);
        nodeH.addDestination(nodeB, 19);
        nodeH.addDestination(nodeG, 6);

        nodeI.addDestination(nodeH, 21);
        nodeI.addDestination(nodeJ, 10);

        nodeJ.addDestination(nodeB, 7);
        nodeJ.addDestination(nodeC, 15);

        graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);
        graph.addNode(nodeJ);

        return graph;
    }
}
