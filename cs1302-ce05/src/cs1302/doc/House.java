package cs1302.doc;

import java.util.Random;
import java.text.DecimalFormat;

/** This class represents a {@code House} object. Each {@code House} object has
 * an associated {@code price}, and an indicator {@code forSale} for whether or not the
 * {@code House} is currently for sale. 
 *
 * A House object cannot have a negative {@code price}. The
 * constructor and setter methods in this class ensure this condition
 * via exceptions.
 *
 * By default, a {@code House} object is for sale.
 */
public class House {

    private boolean forSale;
    private double price;

    /**
     * Constructs a {@code House} with a random {@code price} between
     * $1000.00 and $100,000.00.
     * By default, a {@code House} object is for sale when it is
     * instantiated
     */
    public House() {
        forSale = true;
        Random r = new Random();
        price = (r.nextInt(9900000) + 100000) / 100.0;
    } // House

    /**
     * Constructs a {@code House} object with a given {@code price}.
     * The value for {@code price} cannot be a negative number.
     * @param price the given price of the {@code House}
     * @throws IllegalArgumentException if {@code price} is negative
     */
    public House(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            if (price < 0) {
                throw new IllegalArgumentException("price cannot be negative");
            }
        } // if
    } // House

    /**
     * Returns a {@code String} representation of this {@code House} object
     * in the following format: House(Price: $ 120,000.00)
     */
    @Override
    public String toString() {
        DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();
        decimalFormatObj.setDecimalSeparatorAlwaysShown(true);
        String s = "";
        decimalFormatObj.setMinimumFractionDigits(2);
        decimalFormatObj.setMaximumFractionDigits(2);
        s += "House(Price: $" + decimalFormatObj.format(getPrice()) + ")";
        return s;
    } // toString

    /**
     * Modifies the {@code price} of this {@code House} with the given
     * {@code price} value. {@code price} is in USD.
     * The value for {@code price} cannot be negative.
     * @param price the given price value
     * @throws IllegalArgumentException if {@code price} is negative
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("price cannot be negative");
        } // if
    } // setPrice

    /**
     * Modifies whether or not the {@code house} is for sale by changing the
     * {@code forSale} instance variable.
     * @param forSale the given status of the house
     */
    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    } // setForSale

    /**
     * Returns {@code true} if this House is for sale and {@code false}
     * otherwise.
     * @return the status of the {@code House}
     */
    public boolean isForSale() throws IllegalArgumentException {
        return forSale;
    } // isForSale

    /**
     * Returns the {@code price} of this {@code House}.
     * @return the {@code price} 
     */
    public double getPrice() {
        return price;
    } // getPrice
} // House
