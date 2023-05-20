package ar.com.problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TravelCase {

    private static final String address_A = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
            + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
            + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
            + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
            + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
            + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
            + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
            + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
            + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
            + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";

    private final String zip_code = "OH 43071,NY 56432,ZP 32908,AE 56210,RE 13000,EX 34342,SW 43098,AA 45521,GG 30654," +
            "ZP 32908,AE 56215,RE 13200,EX 34345,RE 13222,RE 13001,SW 43198,AA 45522,GG 30655,XX 32321,YY 45098";
    public static void main(String[] args) {

        String result = travel(address_A, "AA 45522");
        String otherResult = SolutionWithStreams(address_A, "RE 13200");
        System.out.println(otherResult);

    }
    private static String travel(String r, String zipcode) {

        if (zipcode.isEmpty()) {
            return zipcode + ":/";
        }

        String[] addresses = r.split(",");
        String streets = "", houseNumbers = "/";

        Pattern regex = Pattern.compile("(\\d+)\\s((\\w+\\.?\\s)+)" + zipcode);
        Matcher matcher;

        for (String address : addresses) {
            if (address.endsWith(zipcode)) {
                matcher = regex.matcher(address);
                while (matcher.find()) {
                    houseNumbers += matcher.group(1).trim() + ",";
                    streets += matcher.group(2).trim() + ",";
                }
            }
        }

        if (streets.isEmpty()) {
            return zipcode + ":/";
        } else {
            return zipcode + ":" + streets.substring(0, streets.length() - 1) + houseNumbers.substring(0, houseNumbers.length() - 1);
        }
    }


    private static String SolutionWithStreams(String r, String zipcode) {

        if(zipcode.trim().length() < 8){
            return zipcode + ":/";
        }
        List<String> list = Arrays.stream(r.split(","))
                .filter(s -> s.contains(zipcode))
                .map(s -> s.replace(zipcode, ""))
                .collect(Collectors.toList());

        String codes = list.stream()
                .map(s -> s.split(" ")[0])
                .collect(Collectors.joining(","));
        String addresses = list.stream()
                .map(s -> s.replace(s.split(" ")[0], "").trim())
                .collect(Collectors.joining(","));

        return String.format("%s:%s/%s", zipcode, addresses, codes);
    }


}

