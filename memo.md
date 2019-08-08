## MVCについて
- Model: データを扱う.
- View: モデルのデータの表示.
- Controller: ユーザーからの入力に従ってModelからデータを取り出し，Viewに送る

## 他用語とか
- persistence: オブジェクトが持っている情報をDBに保存するもの? 永続性
- DAO: Data Access Object. DBにアクセスする時に使うオブジェクトで，FacilityDao.scalaとかがそう

## Facilityの動作の流れ
### list
1. /facility/listにアクセスすると `FacilityController.list` が実行される
2. FacilityControllerは `facilityDao` と `daoLocation` を引数として持っている(これらはimportされている)
	- facilityDao: `import persistence.facility.dao.FacilityDAO` でインポートされるやつ.ここにDBからデータをとってくるgetとかfindAllとかが定義されてる．データ変更はこのへんに書けばいいかな？
	- daoLocation: `import persistence.geo.dao.LocationDAO` でインポートされるやつ．こっちは地域情報を持ってこれるやつらしい．全てのlocation idを使って地域情報を持ってきてる．これは検索の都道府県のところにのみ使われてるっぽい (views/site/facility/list/_List.scala.html)
3. for文の中
` for A yield B` : AをやってからBをする, 詳しくはslackの過去ログにある

### edit
これはこれから作るやつの計画
1. /facility/edit?id=n (n = 1 ~ 20) にアクセスすると `FacilityController.edit` が実行される(引数を取る)
2. viewは，書き込み領域と保存ボタンを用意する
3. 変更が押されたらid=nのDBの値をそれで書き換える
	- ボタンが押されたら，の処理 -> searchを参考にする


## 気づいたこと
htmlをオブジェクトとして持っておいて再利用したりしてるっぽい(views/site/facility/list/_List.scala.htmlみるとそんな事やってる)
表示されるサイトのソースと見比べるとわかりやすい
