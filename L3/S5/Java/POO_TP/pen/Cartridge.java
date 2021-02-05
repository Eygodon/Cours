package pen;

import java.awt.Color;

public class Cartridge {

    public final static int DEFAULT_LEVEL = 3;
    private int level;
    private Pen pen = null;
    public final Color COLOR;

    public Cartridge(Color c)
    {
        this.level = DEFAULT_LEVEL;
        this.COLOR = c;

    }

    public void freePen()
    {
        if (this.pen != null) {
            Pen p = this.pen;
            this.pen = null;
            p.freeCart();
        }
    }

    public void setPen(Pen p)
    {
        if (this.pen!=null)
            this.pen.freeCart();
        this.pen = p;
        if (this.pen.getCartridge() != this)
        this.pen.changeCartridge(this);
    }

    public void use()
    {
        if (this.level > 0)
        this.level--;
    }

    public boolean isEmpty()
    {
        return (this.level==0);
    }

    Pen getPen()
    {
        return this.pen;
    }

    public int getLevel()
    {
        return this.level;
    }
}
