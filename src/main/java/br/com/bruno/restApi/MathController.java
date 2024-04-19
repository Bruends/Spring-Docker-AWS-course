package br.com.bruno.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MathController {
    public Double sum;

    @GetMapping("/math/{n1}/{n2}")
    public Double sumer(
            @PathVariable(value = "n1") String n1,
            @PathVariable(value = "n2") String n2
    ) throws Exception {

        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedOperationException("no num val");
        }
        return convertToDouble(n1) + convertToDouble(n2);
    }

    private Double convertToDouble(String strN) {
        if (strN == null) return 0D;
        String number = strN.replaceAll(",", ".");
        if (isNumeric(strN)) return Double.parseDouble(strN);
        return 0D;
    }

    private boolean isNumeric(String strN) {
        if (strN == null) return false;
        String number = strN.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
