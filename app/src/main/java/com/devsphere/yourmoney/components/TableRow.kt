package com.devsphere.yourmoney.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devsphere.yourmoney.R
import com.devsphere.yourmoney.ui.theme.Destructive
import com.devsphere.yourmoney.ui.theme.TextPrimary
import com.devsphere.yourmoney.ui.theme.Typography

@Composable
fun TableRow(
    label: String,
    modifier: Modifier = Modifier,
    detail: (@Composable RowScope.() -> Unit)?,
    hasArrow: Boolean = false,
    isDestructive: Boolean = false,
) {

    val textColor = if (isDestructive) Destructive else TextPrimary

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = Typography.bodyMedium, color = textColor)
        if (hasArrow) {
            Icon(
                painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right_Arrow"
            )
        }
    }
}
