import okhttp3.HttpUrl
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Retrofit

/**
 * Unit tests for validating the base URL used in Retrofit.
 */
class RetrofitBaseUrlTest {

    /**
     * Test to verify that the base URL set in Retrofit is valid and correctly retrieved.
     */
    @Test
    fun testBaseUrlIsValid() {
        val baseUrl = "https://api.example.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .build()

        val url: HttpUrl = retrofit.baseUrl()
        assertNotNull("Base URL is null", url)
        assertEquals("Base URL is incorrect", baseUrl, url.toString())
    }

    /**
     * Test to verify that the base URL is well-formatted and can be successfully parsed.
     */
    @Test
    fun testBaseUrlIsWellFormatted() {
        val baseUrl = "https://api.example.com/"
        val url: HttpUrl? = HttpUrl.parse(baseUrl)
        assertNotNull("Base URL is not well formatted", url)
    }

    /**
     * Test to verify that the scheme of the base URL is HTTPS.
     */
    @Test
    fun testBaseUrlSchemeIsHttps() {
        val baseUrl = "https://api.example.com/"
        val url: HttpUrl? = HttpUrl.parse(baseUrl)
        assertNotNull("Base URL is not well formatted", url)
        assertTrue("Base URL scheme is not HTTPS", url?.toString()?.startsWith("https://") == true)
    }
}
