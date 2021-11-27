package com.example.fakenews.data

import com.example.fakenews.domain.DataSourceInteractor
import com.example.fakenews.presentation.recycler.News

class DataSource: DataSourceInteractor {
    override fun newsList(): List<News> {
        return list
    }

   private val list: List<News> = listOf(
        News(
            "title1",
            "author1",
            "26.11.2021",
            "Политика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title2",
            "author3",
            "19.11.2021",
            "Технологии",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title3",
            "author2",
            "19.11.2021",
            "Игры",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title4",
            "author1",
            "26.10.2021",
            "Экономика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title5",
            "author4",
            "25.11.2021",
            "Политика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title6",
            "author4",
            "19.11.2021",
            "Технологии",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title7",
            "author1",
            "26.10.2021",
            "Игры",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title8",
            "author3",
            "26.11.2021",
            "Экономика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title9",
            "author3",
            "25.11.2021",
            "Политика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title10",
            "author1",
            "26.10.2021",
            "Технологии",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title11",
            "author2",
            "19.11.2021",
            "Игры",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title12",
            "author4",
            "25.11.2021",
            "Экономика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title13",
            "author4",
            "26.11.2021",
            "Политика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title14",
            "author3",
            "25.11.2021",
            "Технологии",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title15",
            "author2",
            "26.10.2021",
            "Игры",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        ),
        News(
            "title16",
            "author2",
            "26.11.2021",
            "Экономика",
            "Одна Activity, 2 фрагмента. 1 Фрагмент со списком новостей и кнопкой “Фильтровать\n" +
                    "по”. По нажатию на кнопку открывается второй фрагмент с RadioGroup, где выбирается\n" +
                    "критерий для фильтрации."
        )
    )
}



