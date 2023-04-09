package com.devsphere.yourmoney.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.unit.dp
import com.devsphere.yourmoney.R
import com.devsphere.yourmoney.ui.theme.Destructive
import com.devsphere.yourmoney.ui.theme.TextPrimary
import com.devsphere.yourmoney.ui.theme.Typography

@Composable
fun TableRow(
    modifier: Modifier = Modifier,
    label: String,
    hasArrow: Boolean = false,
    isDestructive: Boolean = false,
    detailContent: (@Composable RowScope.() -> Unit)? = null,
    content: (@Composable RowScope.() -> Unit)? = null,
) {

    val textColor = if (isDestructive) Destructive else TextPrimary

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically,
    ) {
        if (label != null) {
            Text(
                text = label,
                style = Typography.bodyMedium,
                color = textColor,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
        if (content != null) {
            content()
        }
        if (hasArrow) {
            Icon(
                painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right_Arrow",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
        if (detailContent != null) {
            detailContent()
        }
    }
}
