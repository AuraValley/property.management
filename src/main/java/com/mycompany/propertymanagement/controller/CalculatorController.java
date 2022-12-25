package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {
    //http://localhost:8084/api/v1/calculator/add?num1=4.5&num2=8.4
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2 ,@RequestParam("num3") Double num3)
        {
            return num1 + num2 +num3;
        }
        @GetMapping("/sub/{num1}/{num2}")
        public Double subtract(@PathVariable("num1") Double num1 , @PathVariable("num2") Double num2)
        {
            Double result=null;
            if(num1>num2)
            {
                result=num1-num2;
            }
            else{
                result=num2-num1;
            }
            return result;
        }
        @PostMapping("/mul")
        public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO)
        { Double result=null;
            result=calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
            ResponseEntity<Double> responseEntity= new ResponseEntity<Double>(result, HttpStatus.CREATED);
            return responseEntity;

        }
    }

