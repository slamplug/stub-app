package uk.slamplug.test.stubapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.slamplug.test.stubapp.db.CustomerDB;

@Controller
@SuppressWarnings("UnusedDeclaration")
@RequestMapping("/db")
public class StubAppController {
    private static final Logger logger = LoggerFactory.getLogger(StubAppController.class);

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCustomerDetails(@PathVariable("id") long id) throws IOException {
        logger.debug("getCustomerDetails, id {" + id + "}");
        return new ObjectMapper().writer().withDefaultPrettyPrinter().
                writeValueAsString(new CustomerDB().getCustomerDetails(id));
    }
}
