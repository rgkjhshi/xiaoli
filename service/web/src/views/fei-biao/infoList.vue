<template>
  <div class="app-container">
    <el-row>
      <el-col :offset="4" :span="16">
        <el-tabs value="0" type="card" @tab-click="handleTabClick">
          <el-tab-pane>
            <span slot="label"><span class="tab">买方</span></span>
            <!-- 买方列表数据 -->
            <el-card v-for="info in dataList" :key="info.id" shadow="hover">
              <el-descriptions :title="info.title" :column="4">
                <template slot="extra">
                  发布时间：{{ info.createTime }}
                </template>
                <el-descriptions-item label="标签" :span="4">
                  <el-tag v-for="tag in info.tagList" :key="tag" type="info" size="small">{{ tag }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="企业性质">{{ info.enterpriseType }}</el-descriptions-item>
                <el-descriptions-item label="资产规模">{{ info.assertScale }}</el-descriptions-item>
                <el-descriptions-item label="所在地区">{{ info.enterpriseArea }}</el-descriptions-item>
                <el-descriptions-item label="所属行业">{{ info.industry }}</el-descriptions-item>
                <el-descriptions-item label="投资方式">
                  <el-tag size="small">{{ info.investmentType }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="投资对价">
                  <el-tag type="danger" size="small">{{ info.consideration }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="目标资产类型">
                  <el-tag type="success" size="small">{{ info.targetAssertType }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="预期投资收益率">{{ info.expectRate }}</el-descriptions-item>
                <el-descriptions-item label="投资周期" :span="2">{{ info.investmentCycle }}</el-descriptions-item>
                <el-descriptions-item label="有效期限" :span="2">{{ info.validPeriod }}</el-descriptions-item>
                <el-descriptions-item label="限制条件" :span="4">{{ info.restrictions }}</el-descriptions-item>
                <el-descriptions-item label="简介" :span="4">{{ info.introduce }}</el-descriptions-item>
              </el-descriptions>
            </el-card>
          </el-tab-pane>
          <el-tab-pane>
            <span slot="label"><span class="tab">卖方</span></span>
            <!-- 卖方列表数据 -->
            <el-card v-for="info in dataList2" :key="info.id" shadow="hover">
              <el-descriptions :title="info.title" :column="4">
                <template slot="extra">
                  发布时间：{{ info.createTime }}
                </template>
                <el-descriptions-item label="标签" :span="4">
                  <el-tag v-for="tag in info.tagList" :key="tag" type="info" size="small">{{ tag }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="企业性质">{{ info.enterpriseType }}</el-descriptions-item>
                <el-descriptions-item label="企业所在地区">{{ info.enterpriseArea }}</el-descriptions-item>
                <el-descriptions-item label="资产所属行业">{{ info.industry }}</el-descriptions-item>
                <el-descriptions-item label="资产所在地区">{{ info.assertArea }}</el-descriptions-item>
                <el-descriptions-item label="出让方式">
                  <el-tag size="small">{{ info.transferType }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="交易对价">
                  <el-tag type="danger" size="small">{{ info.consideration }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="资产类型">
                  <el-tag type="success" size="small">{{ info.targetAssertType }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="可接受成本或折扣率">{{ info.expectPrice }}</el-descriptions-item>
                <el-descriptions-item label="资产描述" :span="2">{{ info.area }}</el-descriptions-item>
                <el-descriptions-item label="有效期限">{{ info.validPeriod }}</el-descriptions-item>
              </el-descriptions>
            </el-card>
          </el-tab-pane>
        </el-tabs>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import clip from '@/utils/clipboard' // use clipboard directly
import clipboard from '@/directive/clipboard/index.js' // use clipboard by v-directive

export default {
  name: 'InfoList',
  directives: {
    clipboard
  },
  data() {
    return {
      dataList: [
        {
          'title': '三一集团其他质保研发询比价询比价公告',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '国企',
          'assertScale': '100亿',
          'industry': '农林牧渔',
          'enterpriseArea': '北京市',
          'investmentType': '参股',
          'consideration': '10亿',
          'targetAssertType': '有价证券',
          'expectRate': '5%-6%',
          'restrictions': '条件123',
          'investmentCycle': '2年',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09',
          'introduce': '内容简介'
        },
        {
          'title': '汉中市南郑区国有资产经营有限责任公司关于南郑区香居酒店招租',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '央企',
          'assertScale': '100亿',
          'industry': '农林牧渔',
          'enterpriseArea': '北京市',
          'investmentType': '全资',
          'consideration': '10亿',
          'targetAssertType': '不动产',
          'expectRate': '5%-6%',
          'restrictions': '条件123',
          'investmentCycle': '2年',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09',
          'introduce': '内容简介'
        },
        {
          'title': '北京市首发建设大厦工程设计中标候选人公示',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '民营企业',
          'assertScale': '100亿',
          'industry': '农林牧渔',
          'enterpriseArea': '北京市',
          'investmentType': '控股',
          'consideration': '10亿',
          'targetAssertType': '股权',
          'expectRate': '5%-6%',
          'restrictions': '条件123',
          'investmentCycle': '2年',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09',
          'introduce': '内容简介'
        }
      ],
      dataList2: [
        {
          'title': '三一集团其他质保研发询比价询比价公告',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '国企',
          'enterpriseArea': '北京市',
          'transferType': '卖断',
          'consideration': '10亿',
          'industry': '农林牧渔',
          'targetAssertType': '有价证券',
          'assertArea': '北京市',
          'assertInfo': '资产描述',
          'expectPrice': '九五折',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09'
        },
        {
          'title': '三一集团其他质保研发询比价询比价公告',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '国企',
          'enterpriseArea': '北京市',
          'transferType': '后续回购',
          'consideration': '10亿',
          'industry': '农林牧渔',
          'targetAssertType': '有价证券',
          'assertArea': '北京市',
          'assertInfo': '资产描述',
          'expectPrice': '5%-6%',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09'
        },
        {
          'title': '三一集团其他质保研发询比价询比价公告',
          'tagList': ['标签1', '标签2', '标签3'],
          'enterpriseType': '国企',
          'enterpriseArea': '北京市',
          'transferType': '介于两者之间',
          'consideration': '10亿',
          'industry': '农林牧渔',
          'targetAssertType': '有价证券',
          'assertArea': '北京市',
          'assertInfo': '资产描述',
          'expectPrice': '5%-6%',
          'validPeriod': '2023-05-01',
          'createTime': '2023-01-09'
        }
      ],
      activeTabName: 'tab1',
      queryRequest: {
        // 过滤条件, 0:买方，1:卖方
        infoFilter: 0,
        // 页码
        pageNum: 1,
        // 页面大小
        pageSize: 10
      }
    }
  },
  methods: {
    handleCopy(text, event) {
      clip(text, event)
    },
    clipboardSuccess() {
      this.$message({
        message: 'Copy successfully',
        type: 'success',
        duration: 1500
      })
    },
    handleTabClick(tab, event) {
      // 审批过滤条件, 0:卖方，1:卖方
      const currentFilter = this.queryRequest.infoFilter
      const targetFilter = parseInt(tab.index)
      if (targetFilter !== currentFilter) {
        this.queryRequest.infoFilter = targetFilter
        console.log(this.queryRequest)
      }
    }
  }
}
</script>

<style>
.tip {
  background-color: #ecf8ff;
  border-radius: 4px;
  border-left: 5px solid #50bfff;
}
.tip-error {
  background-color: #fff6f7;
  border-radius: 4px;
  border-left: 5px solid #fe6c6f;
}
.tip-content {
  font-size: 14px;
  color: #5e6d82;
  line-height: 1.5em;
}
.el-tag + .el-tag {
  margin-left: 10px;
}
.button-new-tag {
  margin-left: 10px;
  height: 28px;
  line-height: 26px;
  padding-top: 0;
  padding-bottom: 0;
}
.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
.el-card:hover {
  background-color: #ebf5ff !important;
}
.el-card + .el-card {
  margin-top: 5px;
}
.el-descriptions__body {
  background-color: transparent !important;
}
.company-name {
  color: #409eff;
}
.tab {
  width: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
}

</style>
