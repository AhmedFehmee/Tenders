package com.example.ahmed.tendercs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class NewsList extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        Button news_1 = (Button) findViewById(R.id.bt_one);
        Button news_2 = (Button) findViewById(R.id.bt_Two);
        Button news_3 = (Button) findViewById(R.id.bt_3);

        news_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(NewsList.this , News_describtion.class);

                news.putExtra("title", "بعد قليل.. وزير الاستثمار يناقش قضايا المنقصات بمؤتمر صحفي ");
                news.putExtra("describtion","\"يعقد وزير الاستثمار  المهندس شريف إسماعيل، بعد قليل، مؤتمرًا صحفيًا مساء اليوم الأربعاء 15 إبريل، وذلك بمقر الوزراء يناقش المؤتمر القضايا المختلفة في قطاع الاستثمار، كما يطرح رؤية لتطوير والتنمية في المرحلة القادمة والفلسفة الجديدة لوزارة الاسثمار حول دعم المصروفات وتطوير القطاع.بمدينة نصر\"");
                startActivity(news);
            }
        });

        news_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(NewsList.this , News_describtion.class);

                news.putExtra("title","السلع التموينيه تعلن عن مناقصه لتوريد الارز");
                news.putExtra("describtion", "قررت شعبة صناعة ضرب الأرز بغرفة صناعة الحبوب قصر التقدم لمناقصات الأرز التي تعلن عنها الهيئة العامة للسلع التموينية علي المضارب فقط، لضمان الالتزام بالتوريد مع وضع حد أدني يبلغ 1000 طن وحد أقصي 2000 طن للتقدم للمناقصات التموينية وذلك لإتاحة الفرصة لأكبر عدد من المضارب\n" +
                        "هذا فيما رأي أعضاء الشعبة أنه يجب قصر دخول المناقصات التموينية علي مضارب الأرز وإلغاء العقود المبرمة بين المضارب وبين شركات التعبئة \n" +
                        "علي أن يجب وضع حدًا أدني 1000 طن وحدًا أقصي 2000 طن للتقدم للمناقصة الواحدة، وذلك لإتاحة الفرصة لأكبر عدد من المضارب لدخول لهذه المناقصات");

                startActivity(news);
            }
        });

        news_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(NewsList.this , News_describtion.class);
                news.putExtra("title", "«المالية» البرلمانية تناقش غداً التعديلات الجديدة على قانون المناقصات");
                news.putExtra("describtion","بعد أن تم حسم الخلاف الحكومي بشأن قانون المناقصات العامة تسلمت لجنة الشؤون المالية والاقتصادية البرلمانية تعديلات حكومية جديدة على القانون، لتقوم اللجنة بمناقشتها إلى جانب الاقتراحات النيابية في اجتماعها غداً، بحسب ما أفاد رئيسها \n" +
                        "اللجنة ستناقش الخطوط العريضة للقانون، وستقارن بين التعديلات الحكومية الجديدة وما تم إنجازه»، مشيراً إلى أنه «مازال هناك خلاف بين فريق العمل والحكومة حول عدة مواد، من بينها عدم رغبة الحكومة أن تكون المكاتب الاستشارية ضمن القانون");
                startActivity(news);
            }
        });
    }
}