package br.com.giovannamakida.ludoon.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.giovannamakida.ludoon.R
import br.com.giovannamakida.ludoon.models.Story
import br.com.giovannamakida.ludoon.ui.theme.StoryCircleColor
import br.com.giovannamakida.ludoon.ui.theme.spacingSmall

@Composable
fun StoryItem(story: Story) {
    Column(
        modifier = Modifier
            .padding(spacingSmall)
            .background(MaterialTheme.colorScheme.background)
    ) {

        AsyncImage(
            model = story.userAvatar,
            contentDescription = stringResource(
                R.string.story_content_description,
                story.userNickName
            ),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
                .clip(CircleShape)
                .border(2.dp, StoryCircleColor, CircleShape),
            contentScale = ContentScale.Fit
            //placeholder = painterResource(R.drawable.placeholder), // opcional
            //error = painterResource(R.drawable.error) // opcional
        )

        Text(
            story.userNickName, modifier = Modifier
                .width(72.dp)
                .height(24.dp),
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AsyncImage(model: String, contentDescription: Any, modifier: Any, contentScale: Any) {

}

@Preview
@Composable
fun StoryItemPreview(modifier: Modifier = Modifier) {
    StoryItem(Story("", ""))
}