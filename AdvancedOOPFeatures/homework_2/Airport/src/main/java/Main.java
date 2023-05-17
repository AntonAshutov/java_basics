import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);
        flights.forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> (flight.getDate().before(new Date(System.currentTimeMillis() + 7_200_000))
                        && flight.getDate().after(new Date(System.currentTimeMillis()))
                        && flight.getType().equals(Flight.Type.DEPARTURE)))
                .collect(Collectors.toList());
    }
}