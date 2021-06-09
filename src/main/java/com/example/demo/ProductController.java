package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Controller
public class ProductController {
    @Autowired
    private ProductRepo repo;
    @PostMapping("/post")
    public String put(@RequestBody Product product) {
        if (product.getOperation()=='+') {
            product.setResult(product.getInput1() + product.getInput2());
        }else if (product.getOperation()=='-') {
            product.setResult(product.getInput1() - product.getInput2());
        }else if (product.getOperation()=='*') {
            product.setResult(product.getInput1() * product.getInput2());
        }else if (product.getOperation()=='/') {
            product.setResult(product.getInput1() / product.getInput2());
        }
        repo.save(product);
        return product.toString();
    }

}
