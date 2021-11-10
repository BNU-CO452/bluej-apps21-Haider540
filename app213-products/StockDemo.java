
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
    public StockDemo()
    {
        this.stock = new StockList();
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "farcry 4"));
        stock.add(new Product(102, "fifa 22"));
        stock.add(new Product(103, "call of duty"));
        stock.add(new Product(104, "warezone"));
        stock.add(new Product(105, "minecraft"));
        stock.add(new Product(106, "WWE"));
        stock.add(new Product(107, "super mario"));
        stock.add(new Product(108, "forza horizon"));
        stock.add(new Product(109, "rocket league"));
        stock.add(new Product(110, "battlefield"));
        
        runDemo();
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
        stock.buyProduct(101, 50);
        stock.buyProduct(102, 40);
        stock.buyProduct(103, 20);
        stock.buyProduct(104, 10);
        stock.buyProduct(105, 80);
        stock.buyProduct(106, 90);
        stock.buyProduct(107, 78);
        stock.buyProduct(108, 56);
        stock.buyProduct(109, 87);
        stock.buyProduct(110, 69);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 20);
        stock.sellProduct(102, 30);
        stock.sellProduct(103, 4);
        stock.sellProduct(104, 2);
        stock.sellProduct(105, 22);
        stock.sellProduct(106, 20);
        stock.sellProduct(107, 23);
        stock.sellProduct(108, 23);
        stock.sellProduct(109, 21);
        stock.sellProduct(110, 20);
    }    
}