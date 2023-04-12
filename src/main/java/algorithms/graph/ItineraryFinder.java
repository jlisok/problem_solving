package algorithms.graph;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://www.techiedelight.com/find-itinerary-from-given-list-tickets/">link</a>
 * <p>
 * <b>Find itinerary from the given list of departure and arrival airports</b>
 * <p>
 * Given a list of departure and arrival airports, find the itinerary in order.
 * It may be assumed that departure is scheduled from every airport except the final destination,
 * and each airport is visited only once, i.e., there are no cycles in the route.
 * <p>
 * Example:
 * <p>
 * Input:
 * {HKG, DXB}
 * {FRA, HKG}
 * {DEL, FRA}
 * <p>
 * Output:
 * DEL —> FRA —> HKG —> DXB
 * <p>
 * Input:
 * {LAX, DXB}
 * {DFW, JFK}
 * {LHR, DFW}
 * {JFK, LAX}
 * <p>
 * Output: LHR —> DFW —> JFK —> LAX —> DXB
 */
public class ItineraryFinder {
    private static final String ARROW = " --> ";

    public String find(String[][] sourceDestinations) {
        if (sourceDestinations == null) return null;

        var adjacencyMap = transformToAdjacencyMap(sourceDestinations);
        var source = findSource(adjacencyMap);

        if (source == null) return null;

        var resultBuilder = new StringBuilder();
        resultBuilder.append(source);
        var current = source;

        while (adjacencyMap.containsKey(current)) {

            current = adjacencyMap.get(current);
            resultBuilder.append(ARROW).append(current);

        }

        return resultBuilder.toString();
    }

    private Map<String, String> transformToAdjacencyMap(String[][] sourceDestinations) {
        return Stream.of(sourceDestinations)
                .map(item -> Map.entry(item[0], item[1]))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String findSource(Map<String, String> adjacencyMap) {
        var destinations = adjacencyMap.values();

        var sources = adjacencyMap.keySet().stream()
                .filter(item -> !destinations.contains(item))
                .toList();

        return Optional.of(sources)
                .filter(list -> list.size() == 1)
                .map(list -> list.get(0))
                .orElse(null);
    }
}
