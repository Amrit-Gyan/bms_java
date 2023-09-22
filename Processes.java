

public interface Processes {
    void Deposit(long AcNo,String name);
    void Withdraw(long AcNo);
    void BalanceEnquiry(long AcNo);
    void Update(long AcNo);
    void AccountDetails(long AcNo);
}
