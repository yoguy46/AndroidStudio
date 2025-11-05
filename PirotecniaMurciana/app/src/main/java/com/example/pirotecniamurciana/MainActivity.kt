package com.example.pirotecniamurciana

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var miWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)           //  ÚNICO setContentView

        miWebView = findViewById(R.id.webView)           //  del XML
        miWebView.webViewClient = WebViewClient()        // Mantener navegación dentro
        miWebView.settings.javaScriptEnabled = true
        miWebView.loadUrl("https://pirotecniamurciana.net/")

        // Ajuste de insets (ahora sí existe R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val sb = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sb.left, sb.top, sb.right, sb.bottom)
            insets
        }
    }

    @Deprecated("onBackPressed is fine para un ejemplo simple")
    override fun onBackPressed() {
        if (this::miWebView.isInitialized && miWebView.canGoBack()) {
            miWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        // Limpieza del WebView (buena práctica)
        if (this::miWebView.isInitialized) {
            miWebView.destroy()
        }
        super.onDestroy()
    }
}
