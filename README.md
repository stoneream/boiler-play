# boiler-play

## プロジェクト構成

| プロジェクト | 内容                               |
| ------------ | ---------------------------------- |
| endpoint     | Tapir のエンドポイント定義         |
| server       | サーバー実装                       |
| gendoc       | OpenAPI Specification の生成ツール |
| logging      | ロギングユーティリティ             |
| database     | DTO                                |

## OpenAPI Specification の生成

```bash
sbt "gendoc/run --output-dir docs"
```

## 開発用データベースの初期化

`db/migration` 以下にマイグレーションファイルを配置する。

```bash
docker compose up -d 
```

# DTOの生成

`project/scalikejdbc.properties.sample` を `project/scalikejdbc.properties` にコピーし環境に合わせて設定値を編集する。

```bash
sbt "database/scalikejdbcGen table_name"
```
