package Pack;

import Delivery.Delivery;
import Pack.Composite.CompositePackage;
import Pack.Composite.Order;
import Pack.Composite.Package;

import java.util.ArrayList;

public class Facade {
    private Delivery company;

    public Facade(Delivery company) {
        this.company = company;
    }

    public void makeOrder() {

    }

    public void fillComposite(Order order) {
        ArrayList<Package> packs = company.getPackages();

        for (Package p : packs) {
            if (p.getClass() == CompositePackage.class) {
                CompositePackage pa = (CompositePackage) p;
                pa.add(order);
            }
        }
    }

    public void newComposite(Order order) {
        CompositePackage compositePackage = new CompositePackage("new");

        compositePackage.add(order);

        company.addPack(compositePackage);
    }
}