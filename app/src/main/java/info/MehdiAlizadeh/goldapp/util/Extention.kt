package info.MehdiAlizadeh.goldapp.util

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

/**
 * Extension functions for formatting integers as prices.
 */
object Extension {

    /**
     * Formats the integer as a price string.
     * @param locale The locale to use for formatting the price (default is "fa_IR").
     * @return The formatted price string.
     */
    fun Int.formatAsPrice(locale: Locale = Locale("fa", "IR")): String {
        val format: NumberFormat = NumberFormat.getCurrencyInstance(locale)
        if (format is DecimalFormat) {
            format.decimalFormatSymbols.currencySymbol = "ریال " // Sets the currency symbol to "ریال"
        }
        return format.format(this)
    }
}
