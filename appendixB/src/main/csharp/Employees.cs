﻿using System;

namespace Employees
{
    public class SalariedEmployee
    {
        private string name;
        private decimal basePay;

        public SalariedEmployee(string name, decimal basePay)
        {
            this.name = name;
            this.basePay = basePay;
        }

        public decimal CalculatePay(decimal taxRate)
        {
            return basePay - basePay * taxRate;
        }
    }

    public class HourlyEmployee
    {
        private string name;
        private decimal basePay;
        private int timeCard;

        public HourlyEmployee(string name, decimal basePay, int timeCard)
        {
            this.name = name;
            this.basePay = basePay;
            this.timeCard = timeCard;
        }

        public decimal CalculatePay(decimal taxRate)
        {
            return (basePay * timeCard) - (basePay * timeCard) * taxRate;
        }
    }

    public class TaxOffice
    {
        public decimal Calculate(dynamic employee, decimal taxRate)
        {
            return employee.CalculatePay(taxRate);
        }
    }
}
