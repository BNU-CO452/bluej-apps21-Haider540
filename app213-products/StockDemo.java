
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Haider Imam
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "farcry 4"));
        stock.add(new Product(102, "fifa 22"));
        stock.add(new Product(103, "call of duty 2"));
        stock.add(new Product(104, "call of duty warzone"));
        stock.add(new Product(105, "minecraft"));
        stock.add(new Product(106, "WWE 2k17"));
        stock.add(new Product(107, "super mario 64"));
        stock.add(new Product(108, "forza horizon 5"));
        stock.add(new Product(109, "rocket league"));
        stock.add(new Product(110, "battlefield 2042"));
        
        
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 3);
        stock.buyProduct(102, 4);
        stock.buyProduct(103, 6);
        stock.buyProduct(104, 7);
        stock.buyProduct(105, 10);
        stock.buyProduct(106, 5);
        stock.buyProduct(107, 3);
        stock.buyProduct(108, 2);
        stock.buyProduct(109, 1);
        stock.buyProduct(110, 4);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 1);
        stock.sellProduct(102, 2);
        stock.sellProduct(103, 3);
        stock.sellProduct(104, 4);
        stock.sellProduct(105, 6);
        stock.sellProduct(106, 1);
        stock.sellProduct(107, 2);
        stock.sellProduct(108, 1);
        stock.sellProduct(109, 1);
        stock.sellProduct(110, 3);
    }    
}