/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package persistence.facility.model

import play.api.data._
import play.api.data.Forms._
import java.time.LocalDateTime
import persistence.geo.model.Location

// 施設情報 (sample)
//~~~~~~~~~~~~~
case class Facility(
  id:          Option[Facility.Id],                // 施設ID
  locationId:  Location.Id,                        // 地域ID
  name:        String,                             // 施設名
  address:     String,                             // 住所(詳細)
  description: String,                             // 施設説明
  updatedAt:   LocalDateTime = LocalDateTime.now,  // データ更新日
  createdAt:   LocalDateTime = LocalDateTime.now   // データ作成日
)

// 施設検索
case class FacilitySearch(
  locationIdOpt: Option[Location.Id]
)

// 施設削除
case class FacilityDelete(
  IdOpt: Option[Facility.Id]
)

// 施設情報変更
case class FacilityEdit(
  locationIdOpt: Option[Location.Id],
  nameOpt:        Option[String],                             // 施設名
  addressOpt:     Option[String],                             // 住所(詳細)
  descriptionOpt: Option[String]                              // 施設説明
)

// コンパニオンオブジェクト
//~~~~~~~~~~~~~~~~~~~~~~~~~~
object Facility {

  // --[ 管理ID ]---------------------------------------------------------------
  type Id = Long

  // --[ フォーム定義 ]---------------------------------------------------------
  val formForFacilitySearch = Form(
    mapping(
      "locationId" -> optional(text),
    )(FacilitySearch.apply)(FacilitySearch.unapply)
  )

  val formForFacilityDelete = Form(
    mapping(
      "id" -> optional(longNumber),
    )(FacilityDelete.apply)(FacilityDelete.unapply)
  )

  val formForFacilityEdit = Form(
    mapping(
      "locationId" -> optional(text),
      "name" -> optional(text),
      "address" -> optional(text),
      "description" -> optional(text),
      )(FacilityEdit.apply)(FacilityEdit.unapply)
  )
}

