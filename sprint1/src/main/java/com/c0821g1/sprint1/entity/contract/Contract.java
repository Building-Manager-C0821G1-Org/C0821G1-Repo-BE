package com.c0821g1.sprint1.entity.contract;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.space.Spaces;

import javax.persistence.*;

@Entity(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "contract_id", nullable = false)
    private Integer contractId;

    @JoinColumn(name = "contract_expired", nullable = false)
    private String contractExpred;

    @JoinColumn(name = "contract_date_start", nullable = false)
    private String contractDateStart;

    @JoinColumn(name = "contract_date_end", nullable = false)
    private String contractDateEnd;

    @JoinColumn(name = "contract_total", nullable = false)
    private String contractTotal;

    @JoinColumn(name = "contract_content", nullable = false)
    private String contractContent;

    @JoinColumn(name = "contract_delete_flag", nullable = false)
    private Boolean contractDeleteFlag;

    @JoinColumn(name = "contract_price", nullable = false)
    private Boolean contractPrice;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "space_id", nullable = false)
    private Spaces spaces;



    public Contract() {

    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractExpred() {
        return contractExpred;
    }

    public void setContractExpred(String contractExpred) {
        this.contractExpred = contractExpred;
    }

    public String getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(String contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public String getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(String contractDateEnd) {
        this.contractDateEnd = contractDateEnd;
    }

    public String getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(String contractTotal) {
        this.contractTotal = contractTotal;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Boolean getContractDeleteFlag() {
        return contractDeleteFlag;
    }

    public void setContractDeleteFlag(Boolean contractDeleteFlag) {
        this.contractDeleteFlag = contractDeleteFlag;
    }

    public Boolean getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Boolean contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Spaces getSpaces() {
        return spaces;
    }

    public void setSpaces(Spaces spaces) {
        this.spaces = spaces;
    }
}
