package structer.facade;

import java.sql.Statement;

//把某个复杂流程中涉及到的接口进行打包整合，客户端只调用整合后的类对应方法即可
public class Facade {
    private AdminOfIndustry admin;
    private Bank bank;
    private Taxation taxation;
    public Facade(){
        admin = new AdminOfIndustry();
        bank = new Bank();
        taxation = new Taxation();
    }
    public void openCompany(String name) {
        this.admin.register(name);
        String bankAccount = this.bank.openAccount(name);
        System.out.println(bankAccount);
        String taxCode = this.taxation.applyTaxCode(name);
        System.out.println(taxCode);

    }
}
