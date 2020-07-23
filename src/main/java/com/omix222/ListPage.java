package com.omix222;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public ListPage() {
        List<PersonBean> dataList = new ArrayList<>();
        dataList = createDataList();

//Repeater系のwicketのAPIであるDataViewを使いました。他にはListViewもあります。
//配列であるdataList変数はListDataProviderクラスを使ってWicketで制御できるように変換しました。
        DataView<PersonBean> repeat = new DataView<PersonBean>("repeat", new ListDataProvider<PersonBean>(dataList)) {
            private static final long serialVersionUID = 1L;

            //繰り返し実行するメソッドです。
            @Override
            protected void populateItem(Item<PersonBean> item) {
//配列から順番に取得したPersonBean情報はitem変数に格納されているのでgetModelObject()取得しました。
                PersonBean person = item.getModelObject();
                item.add(new Label("id", person.getId()));
                item.add(new Label("dep", person.getDep()));
                item.add(new Label("rank", person.getRank()));
                item.add(new Label("sex", person.getSex()));
            }
        };
//ページング処理、1ページに10個のデータを表示する。
        repeat.setItemsPerPage(10);
        add(repeat);
//wicketが提供するページングを使います。第2引数はDataViewであるrepeatです。
        add(new AjaxPagingNavigator("navigator", repeat));
    }

    // 実際はDBからデータを取得する
    private ArrayList<PersonBean> createDataList() {
        ArrayList<PersonBean> list = new ArrayList<PersonBean>();
        list.add(new PersonBean("10003248", "営業", "課長", "男"));
        list.add(new PersonBean("10003278", "開発", "社員", "女"));
        list.add(new PersonBean("10003348", "総務", "社員", "男"));
        list.add(new PersonBean("10004341", "人事", "課長", "女"));
        list.add(new PersonBean("10004987", "企画", "社員", "男"));
        list.add(new PersonBean("10005782", "企画", "社員", "男"));
        list.add(new PersonBean("10008711", "総務", "社員", "女"));
        list.add(new PersonBean("10008712", "営業", "社員", "男"));
        list.add(new PersonBean("10008730", "開発", "社員", "女"));
        list.add(new PersonBean("10008882", "企画", "社員", "男"));
        list.add(new PersonBean("10008942", "人事", "社員", "女"));
        list.add(new PersonBean("10009292", "営業", "社員", "女"));
        list.add(new PersonBean("10009498", "営業", "社員", "女"));
        list.add(new PersonBean("10009571", "開発", "社員", "女"));
        return list;
    }
}
