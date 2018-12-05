package fralewsmi.shortestpath.server.calculator;

import fralewsmi.shortestpath.server.calculator.model.Graph;
import fralewsmi.shortestpath.server.calculator.model.Node;

public interface ShortestPathAlgorithm {
    Graph calculateShortestPathFromSource(Graph graph, Node source);
}
