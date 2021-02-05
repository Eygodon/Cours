package pen;

import java.awt.*;

public class Pen {

    private Cartridge cartridge;
    private final Cap CAP;

    public Pen()
    {

        this.CAP = new Cap();
    }

    public Pen(String m)
    {
        this.cartridge = new Cartridge(Color.BLACK);
        this.cartridge.setPen(this);
        this.CAP = new Cap(m);
    }

    //removes the cartridge
    public void freeCart()
    {
        if(this.cartridge != null)
        {
            Cartridge c = this.cartridge;
            this.cartridge = null;
            c.freePen();
        }


    }

    public void changeCartridge(Cartridge c)
    {
        if (this.getCartridge() != null)
            this.cartridge.freePen();
        this.cartridge = c;
        if (this.cartridge.getPen() != this)
            this.cartridge.setPen(this);
    }

    public boolean write(String text)
    {
            if (this.getCartridge() != null && !this.cartridge.isEmpty())
            {
                this.cartridge.use();
                System.out.println(text);
                return true;
            }
        else
            return false;
    }

    Cartridge getCartridge()
    {
        return this.cartridge;
    }

}
