1. values/strings.xml
```
<resources>
    <string name="html_text"><![CDATA[<b>The Awesome Sliding Up Panel</b><br/> Brought to you by<br/><a href="http://umanoapp.com">http://umanoapp.com</a>]]></string>
</resources>
```
2. TextView
```
 textView.setText(Html.fromHtml(getString(R.string.html_text)));
```


     








