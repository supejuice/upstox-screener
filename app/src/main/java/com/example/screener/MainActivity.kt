package com.example.screener

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.screener.databinding.ActivityMainBinding
import com.example.screener.feature.portfolio.ui.PortfolioFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val portfolioFragment by lazy { PortfolioFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportFragmentManager.beginTransaction()
            .replace(binding.mainContainer.id, portfolioFragment, portfolioFragment::class.toString())
            .commit()
        binding.mainBottomNav.selectedItemId = R.id.menu_portfolio
    }
}