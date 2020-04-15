<!--<template>-->
  <!--<div class="dashboard-container">-->
    <!--<el-tabs type="border-card" style="height:826px;padding 0">-->
      <!--<el-tab-pane>-->
        <!--<span slot="label">-->
          <!--<i class="el-icon-setting"></i> 数据质量检测-->
        <!--</span>-->
        <!--<el-row :gutter="1">-->
          <!--<el-col :span="6">-->
            <!--<div class="cutline" style="height:785px;border-right: 2px dashed #eee;  ">-->
              <!--<el-row style="width:100%;height:68px;border-bottom: 1px solid #eee; ">-->
                <!--<el-input-->
                  <!--placeholder="请输入内容"-->
                  <!--clearable-->
                  <!--style="width:40%;margin-top:22px;margin-left:12px"-->
                  <!--size="small"-->
                  <!--v-model="filterText"-->
                <!--&gt;</el-input>-->
              <!--</el-row>-->
              <!--<div>-->
                <!--<el-tree-->
                  <!--class="filter-tree"-->
                  <!--:data="treeDoms"-->
                  <!--:props="defaultProps"-->
                  <!--default-expand-all-->
                  <!--@node-click="handleNodeClick2"-->
                  <!--:filter-node-method="filterNode"-->
                  <!--style="margin-left:15px"-->
                  <!--ref="tree"-->
                  <!--:expand-on-click-node="false"-->
                <!--&gt;-->
                  <!--<span class="custom-tree-node" slot-scope="{ node, data }">-->
                    <!--<span>{{ node.label }}</span>-->
                    <!--<span>-->
                      <!--<el-button-->
                        <!--v-if="data.addKidsBT"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="addTreeDialogVisible = true; newTreeLabel='' "-->
                      <!--&gt;-->
                        <!--<i class="el-icon-circle-plus-outline"></i>-->
                      <!--</el-button>-->

                      <!--<el-button-->
                        <!--v-if="data.editBT"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="RegexDialogVisible = true"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-setting"></i>-->
                      <!--</el-button>-->

                      <!--<el-button-->
                        <!--v-if="data.deleteBT"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color :#000"-->
                        <!--@click="verifyDel(node,data)"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-delete"></i>-->
                      <!--</el-button>-->
                    <!--</span>-->
                  <!--</span>-->
                <!--</el-tree>-->
              <!--</div>-->
            <!--</div>-->
          <!--</el-col>-->
          <!--<el-col :span="18">-->
            <!--<div class="cutline" style="height:785px;">-->
              <!--<el-row style="width:100%;height:28px;margin-top:12px;margin-left:8px ;">-->
                <!--<div style="float:left;border-radius: 4px;">-->
                  <!--<el-tag type="success">{{currentCategory || '全部检测'}}模块</el-tag>-->
                <!--</div>-->

                <!--<div style="float:left;border-radius: 4px;">-->
                  <!--<el-tag type="info">规则总数：{{currentTotalRule}}</el-tag>-->
                <!--</div>-->

                <!--<div style="float:right;margin-right: 2% ;">-->
                  <!--<el-button @click="addRule() " size="small" icon="el-icon-circle-plus-outline">新增</el-button>-->
                <!--</div>-->

                <!--<div style="float:right;margin-right: 2% ;width:38%">-->
                  <!--<el-input size="small" placeholder="模糊匹配" v-model="keyword">-->
                    <!--<el-button-->
                      <!--@click="filterTable(keyword)"-->
                      <!--size="small"-->
                      <!--type="primary"-->
                      <!--plain-->
                      <!--slot="append"-->
                      <!--icon="el-icon-search"-->
                    <!--&gt;</el-button>-->
                  <!--</el-input>-->
                <!--</div>-->
                <!--<div style="float:right;margin-right: 2%;border-radius: 4px;">-->
                  <!--<el-button @click="sortByDate" size="small" plain>时间倒序</el-button>-->
                <!--</div>-->
              <!--</el-row>-->
              <!--<el-row-->
                <!--class="cardrow"-->
                <!--style="margin-top:2%; margin-left:2% ; height:660px ;overflow-y: scroll;"-->
              <!--&gt;-->
                <!--<el-col :span="6" v-for="(o, index) in tableData2" :key="o" style="padding:12px">-->
                  <!--<el-card shadow="always" :body-style="{ padding: '0px' }">-->
                    <!--<div slot="header" class="clearfix">-->
                      <!--<el-tag type="info" style="text-overflow:ellipsis">{{o.name}}</el-tag>-->
                      <!--<el-button-->
                        <!--style="float: right; padding: 3px 0;color:red"-->
                        <!--type="text"-->
                        <!--@click="delUnnatural(index,o.id)"-->
                      <!--&gt;删除</el-button>-->
                    <!--</div>-->
                    <!--<div style="padding: 6px;">-->
                      <!--<div style="font-size:8px;margin-top:6px">-->
                        <!--<el-button disabled type="text">作用于：</el-button>-->
                        <!--<span>{{o.tableName!=='[]' ? o.tableName : o.sourceName }}</span>-->
                      <!--</div>-->
                      <!--<div style="font-size:8px;margin-top:6px">-->
                        <!--<el-button disabled type="text">规则类型：</el-button>-->
                        <!--<span type="text">{{o.effect}}</span>-->
                      <!--</div>-->
                      <!--<div style="font-size:8px;margin-top:6px">-->
                        <!--<el-button disabled type="text">检测类型:</el-button>-->
                        <!--<span type="text">{{o.detectionType}}</span>-->
                      <!--</div>-->
                      <!--<el-divider></el-divider>-->
                      <!--<div class="bottom clearfix">-->
                        <!--<time class="time">{{ o.time }}</time>-->
                        <!--<el-button-->
                          <!--style="cursor:pointer;"-->
                          <!--type="text"-->
                          <!--class="button"-->
                          <!--@click="fire(o) ;RsdialogVisible=true"-->
                        <!--&gt;执行</el-button>-->
                      <!--</div>-->
                    <!--</div>-->
                  <!--</el-card>-->
                <!--</el-col>-->
              <!--</el-row>-->
            <!--</div>-->
          <!--</el-col>-->
        <!--</el-row>-->
      <!--</el-tab-pane>-->
    <!--</el-tabs>-->

    <!--<el-dialog-->
      <!--:title="calculateTitle?calculateTitle : '未选择检测模块'"-->
      <!--:visible.sync="instanceRuleDialogVisible"-->
      <!--width="30%"-->
      <!--center-->
    <!--&gt;-->
      <!--<el-dialog width="30%" :visible.sync="innerVisible" append-to-body>-->
        <!--<el-form>-->
          <!--<el-form-item label="数据集">-->
            <!--&lt;!&ndash; <el-select v-model="pojo" filterable placeholder="请选择数据集" style="width:60%">-->
              <!--<el-option-->
                <!--v-for="item in pojoSet"-->
                <!--:key="item.value"-->
                <!--:label="item.label"-->
                <!--:value="item"-->
              <!--&gt;</el-option>-->
            <!--</el-select>&ndash;&gt;-->
            <!--<el-select-->
              <!--style="width:60%"-->
              <!--v-model="pojo"-->
              <!--filterable-->
              <!--remote-->
              <!--reserve-keyword-->
              <!--placeholder="请输入关键词"-->
              <!--:remote-method="remoteMethod"-->
              <!--:loading="loading"-->
            <!--&gt;-->
              <!--<el-option-group v-for="group in options" :key="group.label" :label="group.label">-->
                <!--<el-option-->
                  <!--v-for="item in group.options"-->
                  <!--:key="item.value"-->
                  <!--:label="item.label"-->
                  <!--:value="item"-->
                <!--&gt;</el-option>-->
              <!--</el-option-group>-->
            <!--</el-select>-->
          <!--</el-form-item>-->
        <!--</el-form>-->
        <!--<span slot="footer" class="dialog-footer">-->
          <!--<el-button type="primary" @click="closeInnerDialog(pojo,1)">确 定</el-button>-->
          <!--<el-button @click="innerVisible = false">取 消</el-button>-->
        <!--</span>-->
      <!--</el-dialog>-->

      <!--<el-form-->
        <!--ref="fieldForm"-->
        <!--label-width="120px"-->
        <!--size="small"-->
        <!--:rules="rules"-->
        <!--label-position="left"-->
      <!--&gt;-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="newRuleName"></el-input>-->
        <!--</el-form-item>-->
        <!--<el-form-item v-for="(it,$index) in args" :label="it.label">-->
          <!--<el-row v-if="!it.select">-->
            <!--<el-input-->
              <!--:disabled="it.type=='regex' "-->
              <!--v-model.number="it.values"-->
              <!--:type="it.type"-->
              <!--:placeholder="it.placeholder"-->
            <!--&gt;</el-input>-->
          <!--</el-row>-->
          <!--<el-row v-else>-->
            <!--<el-select-->
              <!--v-if="it.linkDataset.id"-->
              <!--v-model="it.values"-->
              <!--:multiple="it.multiple"-->
              <!--collapse-tags-->
              <!--filterable-->
              <!--:placeholder="it.placeholder"-->
              <!--style="width:60%"-->
            <!--&gt;-->
              <!--<el-option-->
                <!--v-for="el in it.pojoElements"-->
                <!--:label="el.alias"-->
                <!--:value="el.getter"-->
                <!--:key="el.label"-->
              <!--&gt;</el-option>-->
            <!--</el-select>-->
            <!--<el-input-->
              <!--:disabled="logicType=='isNull'"-->
              <!--style="width:60%"-->
              <!--v-else-->
              <!--v-model="it.values"-->
              <!--:placeholder="it.placeholder"-->
            <!--&gt;</el-input>-->
            <!--<el-button-->
              <!--@click="openInnerDialog(it,1);it.pojoElements.length=0"-->
              <!--plain-->
              <!--style="float : right ;width:40%"-->
              <!--size="small"-->
              <!--type="primary"-->
            <!--&gt;{{it.linkDataset.label}}</el-button>-->
          <!--</el-row>-->
          <!--<el-select v-model="logicType" v-if="$index==0 && logic" style="width:60%">-->
            <!--<el-option v-for="val in logic " :label="val.label" :value="val.value" :key="val.label"></el-option>-->
          <!--</el-select>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveMethod">确 定</el-button>-->
        <!--<el-button @click="instanceRuleDialogVisible = false ; showDescription = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--&lt;!&ndash; range &ndash;&gt;-->
    <!--<el-dialog-->
      <!--:title="calculateTitle?calculateTitle : '未选择检测模块'"-->
      <!--:visible.sync="rangeDialogVisible"-->
      <!--width="30%"-->
      <!--center-->
    <!--&gt;-->
      <!--<el-dialog width="30%" :visible.sync="innerVisibleRange" append-to-body>-->
        <!--<el-form>-->
          <!--<el-form-item label="数据集">-->
            <!--<el-select-->
              <!--style="width:60%"-->
              <!--v-model="pojo"-->
              <!--filterable-->
              <!--remote-->
              <!--reserve-keyword-->
              <!--placeholder="请输入关键词"-->
              <!--:remote-method="remoteMethod"-->
              <!--:loading="loading"-->
            <!--&gt;-->
              <!--<el-option-group v-for="group in options" :key="group.label" :label="group.label">-->
                <!--<el-option-->
                  <!--v-for="item in group.options"-->
                  <!--:key="item.value"-->
                  <!--:label="item.label"-->
                  <!--:value="item"-->
                <!--&gt;</el-option>-->
              <!--</el-option-group>-->
            <!--</el-select>-->
          <!--</el-form-item>-->
        <!--</el-form>-->
        <!--<span slot="footer" class="dialog-footer">-->
          <!--<el-button type="primary" @click="closeInnerDialog(pojo,2)">确 定</el-button>-->
          <!--<el-button @click="innerVisibleRange = false">取 消</el-button>-->
        <!--</span>-->
      <!--</el-dialog>-->

      <!--<el-form-->
        <!--ref="fieldForm"-->
        <!--label-width="120px"-->
        <!--v-model="rangeForm"-->
        <!--size="small"-->
        <!--:rules="rules"-->
        <!--label-position="left"-->
      <!--&gt;-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="newRuleName"></el-input>-->
        <!--</el-form-item>-->
        <!--<el-form-item label="待检测字段">-->
          <!--<el-row>-->
            <!--<el-select-->
              <!--v-model="rangeForm.field"-->
              <!--collapse-tags-->
              <!--filterable-->
              <!--placeholder="选择待检测字段"-->
              <!--style="width:60%"-->
            <!--&gt;-->
              <!--<el-option-->
                <!--v-for="el in rangeForm.pojoElements"-->
                <!--:label="el.alias"-->
                <!--:value="el.getter"-->
                <!--:key="el.label"-->
              <!--&gt;</el-option>-->
            <!--</el-select>-->
            <!--<el-button-->
              <!--@click="openInnerDialog(it,2)"-->
              <!--plain-->
              <!--style="float : right ;width:40%"-->
              <!--size="small"-->
              <!--type="primary"-->
            <!--&gt;{{rangeForm.pojo.label}}</el-button>-->
          <!--</el-row>-->
        <!--</el-form-item>-->
        <!--<el-form-item label="检测因子">-->
          <!--<el-row>-->
            <!--<el-select-->
              <!--v-model="rangeForm.logic"-->
              <!--collapse-tags-->
              <!--filterable-->
              <!--placeholder="逻辑因子"-->
              <!--style="width:40%"-->
            <!--&gt;-->
              <!--<el-option v-for="el in logics" :label="el.label" :value="el.value" :key="el.label"></el-option>-->
            <!--</el-select>-->
            <!--<el-input-->
              <!--v-if="rangeType=='number'"-->
              <!--style="width:40%;margin:0"-->
              <!--:placeholder="rangePlaceHandler"-->
              <!--v-model.number="rangeForm.value"-->
              <!--type="number"-->
            <!--&gt;</el-input>-->

            <!--<el-date-picker-->
              <!--v-if="rangeType== 'Date'"-->
              <!--value-format="yyyy-MM-dd"-->
              <!--type="date"-->
              <!--placeholder="选择日期"-->
              <!--v-model="rangeForm.value"-->
              <!--style="width: 40%;"-->
            <!--&gt;</el-date-picker>-->

            <!--<el-button-->
              <!--style="width:15%"-->
              <!--size="small"-->
              <!--class="el-icon-check"-->
              <!--@click="addLogic(rangeForm)"-->
            <!--&gt;</el-button>-->
          <!--</el-row>-->
        <!--</el-form-item>-->
        <!--<el-form-item>-->
          <!--<el-input v-model="rangeForm.factors" disabled></el-input>-->
        <!--</el-form-item>-->
        <!--<el-form-item>-->
          <!--<el-button @click="rangeForm.factors=null" size="small">清空</el-button>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveMethod">确 定</el-button>-->
        <!--<el-button @click="rangeDialogVisible = false ; showDescription = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--&lt;!&ndash; SQL &ndash;&gt;-->
    <!--<el-dialog-->
      <!--:title="calculateTitle?calculateTitle : '未选择检测模块'"-->
      <!--:visible.sync="sqlDialogVisible"-->
      <!--width="30%"-->
      <!--center-->
    <!--&gt;-->
      <!--&lt;!&ndash; <el-dialog width="30%" :visible.sync="innerVisibleSQL" append-to-body>-->
        <!--<el-form>-->
          <!---->
        <!--</el-form>-->
        <!--<span slot="footer" class="dialog-footer">-->
          <!--<el-button type="primary" @click="closeInnerDialog(pojo,3)">确 定</el-button>-->
          <!--<el-button @click="innerVisibleSQL = false">取 消</el-button>-->
        <!--</span>-->
      <!--</el-dialog>&ndash;&gt;-->

      <!--<el-form-->
        <!--ref="fieldForm"-->
        <!--label-width="120px"-->
        <!--v-model="sqlForm"-->
        <!--size="small"-->
        <!--:rules="rules"-->
        <!--label-position="left"-->
      <!--&gt;-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="newRuleName"></el-input>-->
        <!--</el-form-item>-->
        <!--<el-form-item label="数据源">-->
          <!--<el-select v-model="sqlForm.source" filterable placeholder="请选择数据源" style="width:100%">-->
            <!--<el-option-->
              <!--v-for="item in datasource"-->
              <!--:key="item.value"-->
              <!--:label="item.label"-->
              <!--:value="item"-->
            <!--&gt;</el-option>-->
          <!--</el-select>-->
        <!--</el-form-item>-->
        <!--<el-form-item label="SQL">-->
          <!--<el-input type="textarea" v-model="sqlForm.sql" placeholder="自定义SQL 必须带入WID或者主键字段"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveMethod">确 定</el-button>-->
        <!--<el-button @click="rangeDialogVisible = false ; showDescription = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog-->
      <!--:title="widCount"-->
      <!--:visible.sync="RsdialogVisible"-->
      <!--width="60% ;height:668px"-->
      <!--:before-close="handleClose"-->
    <!--&gt;-->
      <!--<div-->
        <!--v-loading="loading"-->
        <!--element-loading-text="计算中"-->
        <!--element-loading-spinner="el-icon-loading"-->
        <!--class="wids"-->
        <!--style=" overflow-y: scroll;  width:100%;height:320px;border: 1px solid #eee;box-shadow: 0 1px 12px 0 rgba(0, 0, 0, 0.1)"-->
      <!--&gt;-->
        <!--<el-tag-->
          <!--v-for="item in wids"-->
          <!--:key="item"-->
          <!--type="danger"-->
          <!--effect="dark"-->
          <!--style="margin: 12px 12px"-->
        <!--&gt;{{ item }}</el-tag>-->
      <!--</div>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button @click="RsdialogVisible = false">取 消</el-button>-->
        <!--<el-button type="primary" @click="RsdialogVisible = false">确 定</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog title="添加层级" :visible.sync="addTreeDialogVisible" width="30%" center>-->
      <!--<el-form ref="form" label-width="80px" size="small" :label-position="labelPosition">-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="newTreeLabel"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="append(newTreeLabel)">确 定</el-button>-->
        <!--<el-button @click="addTreeDialogVisible = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog title="设置层级正则表达式" :visible.sync="RegexDialogVisible" width="30%" center>-->
      <!--<el-form ref="form" label-width="120px" size="small" :label-position="labelPosition">-->
        <!--<el-form-item label="表达式选择">-->
          <!--<el-input v-model="currentRegex"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveRegex">确 定</el-button>-->
        <!--<el-button @click="RegexDialogVisible = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->
  <!--</div>-->
<!--</template>-->

<!--<script>-->
<!--import {-->
  <!--insertMethod,-->
  <!--getMethod2All,-->
  <!--updateMethod,-->
  <!--delMethodByName-->
<!--} from "@/api/Methods";-->
<!--import { getColumns, readPojoById, getCategoryList } from "@/api/pojoset";-->
<!--import { format } from "@/utils/dateformat";-->
<!--import {-->
  <!--save,-->
  <!--getCalculateByCategory,-->
  <!--del,-->
  <!--fireById,-->
  <!--categoryList,-->
  <!--getQualityAll-->
<!--} from "@/api/calculate";-->
<!--import { getDataSourceList } from "@/api/datasource";-->
<!--import { lazyLoadPojo,readCols,dataFields } from "@/api/mdc";-->


<!--export default {-->
  <!--watch: {-->
    <!--filterText(val) {-->
      <!--this.$refs.tree.filter(val);-->
    <!--}-->
  <!--},-->
  <!--data() {-->
    <!--return {-->
      <!--options:[],-->
      <!--datasource: [],-->
      <!--rangePlaceHandler: null,-->
      <!--rangeType: null,-->
      <!--addTreeDialogVisible: false,-->
      <!--rangeDialogVisible: false,-->
      <!--sqlDialogVisible: false,-->
      <!--innerVisibleRange: false,-->
      <!--innerVisibleSQL: false,-->
      <!--treeDoms: [-->
        <!--{-->
          <!--id: 1,-->
          <!--label: "数据重复检测",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: false,-->
          <!--methodId: 1,-->
          <!--ruleType: "唯一性",-->
          <!--data: null,-->
          <!--children: []-->
        <!--},-->
        <!--{-->
          <!--id: 2,-->
          <!--label: "规范检测",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: true,-->
          <!--methodId: 2,-->
          <!--ruleType: "准确性",-->
          <!--data: null,-->
          <!--children: []-->
        <!--},-->
        <!--{-->
          <!--id: 3,-->
          <!--label: "空值检测",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: false,-->
          <!--methodId: 3,-->
          <!--ruleType: "空值",-->
          <!--data: null,-->
          <!--children: []-->
        <!--},-->
        <!--{-->
          <!--id: 4,-->
          <!--label: "引用完整性检查",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: false,-->
          <!--methodId: 4,-->
          <!--ruleType: "正确性",-->
          <!--data: null,-->
          <!--children: []-->
        <!--},-->
        <!--{-->
          <!--id: 0,-->
          <!--label: "值域检查 ",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: false,-->
          <!--methodId: 5,-->
          <!--ruleType: "准确性",-->
          <!--data: null,-->
          <!--children: [-->
            <!--{-->
              <!--id: 5,-->
              <!--label: "数字检查 ",-->
              <!--editBT: true,-->
              <!--deleteBT: false,-->
              <!--addKidsBT: false,-->
              <!--methodId: "5",-->
              <!--ruleType: "准确性",-->
              <!--data: null-->
            <!--},-->
            <!--{-->
              <!--id: 6,-->
              <!--label: "日期检查 ",-->
              <!--editBT: true,-->
              <!--deleteBT: false,-->
              <!--addKidsBT: false,-->
              <!--methodId: "6",-->
              <!--ruleType: "准确性",-->
              <!--data: null-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--id: 7,-->
          <!--label: "自定义SQL检查",-->
          <!--editBT: false,-->
          <!--deleteBT: false,-->
          <!--addKidsBT: false,-->
          <!--methodId: "7",-->
          <!--ruleType: "自定义SQL",-->
          <!--data: null,-->
          <!--children: []-->
        <!--}-->
      <!--],-->
      <!--logics: [-->
        <!--{-->
          <!--label: "<",-->
          <!--value: "<"-->
        <!--},-->
        <!--{-->
          <!--label: "<=",-->
          <!--value: "<="-->
        <!--},-->
        <!--{-->
          <!--label: ">",-->
          <!--value: ">"-->
        <!--},-->
        <!--{-->
          <!--label: ">=",-->
          <!--value: ">="-->
        <!--}-->
      <!--],-->
      <!--rangeForm: {-->
        <!--field: null,-->
        <!--logic: null,-->
        <!--value: null,-->
        <!--pojoElements: [],-->
        <!--pojo: {-->
          <!--label: "关联属性集",-->
          <!--value: null-->
        <!--},-->
        <!--factors: [],-->
        <!--mvel: null-->
      <!--},-->
      <!--sqlForm: {-->
        <!--sql: null,-->
        <!--sourceId: null-->
      <!--},-->
      <!--filterText: null,-->
      <!--newTreeLabel: null,-->
      <!--RegexDialogVisible: false,-->
      <!--currentRegex: null,-->
      <!--currentCategory: null,-->
      <!--calculateTitle: null,-->
      <!--instanceRuleDialogVisible: false,-->
      <!--currentDes: {},-->
      <!--args: null,-->
      <!--logic: null,-->
      <!--newRuleName: null,-->
      <!--innerVisible: false,-->
      <!--currentIt: null,-->
      <!--pojo: {-->
        <!--label: null,-->
        <!--value: null-->
      <!--},-->
      <!--pojoSet: [],-->
      <!--tableData2: [],-->
      <!--wids: [],-->
      <!--widCount: null,-->
      <!--loading: false,-->
      <!--RsdialogVisible: false,-->
      <!--currentTotalRule: null,-->
      <!--keyword: null,-->
      <!--methodDescritions: [-->
        <!--{-->
          <!--name: "1",-->
          <!--effect: "找出数据集中重复的数据。",-->
          <!--arguments: "1.需要计算的一个或多个字段，2.出现重复的次数。",-->
          <!--callback: "返回重复的数据",-->
          <!--mvel:-->
            <!--"matchProvider.excludeByMultipleFieldMap(DataSupport.getOriginData,",-->
          <!--args: [-->
            <!--{-->
              <!--label: "数据库字段",-->
              <!--type: "HashSet",-->
              <!--placeholder: "先关联数据集，再选择字段",-->
              <!--select: true,-->
              <!--multiple: true,-->
              <!--switchValue: true,-->
              <!--values: [],-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--label: "重复次数",-->
              <!--type: "number",-->
              <!--placeholder: "重复次数",-->
              <!--select: false,-->
              <!--switchValue: null,-->
              <!--values: 0-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "2",-->
          <!--effect: "找出与正则表达式不匹配的数据",-->
          <!--arguments: "1.需要计算的字段， 2.正则表达式",-->
          <!--callback: "返回不符合的数据",-->
          <!--mvel:-->
            <!--"matchProvider.regex(DataSupport.getOriginData,DataSupport.regex,",-->
          <!--regex: null,-->
          <!--args: [-->
            <!--{-->
              <!--label: "正则表达式",-->
              <!--type: "regex",-->
              <!--placeholder: "输入或选择正则表达式",-->
              <!--select: false,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: ""-->
            <!--},-->
            <!--{-->
              <!--label: "数据库字段",-->
              <!--type: "String",-->
              <!--placeholder: "校验字段",-->
              <!--select: true,-->
              <!--multiple: false,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "cgBean.",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "3",-->
          <!--mvel:-->
            <!--"matchProvider.calculate(DataSupport.getOriginData,DataSupport.getCompareData,",-->
          <!--args: [-->
            <!--{-->
              <!--label: "数据库字段",-->
              <!--type: "calculate",-->
              <!--placeholder: "选择数据集，再选字段",-->
              <!--select: true,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "4",-->
          <!--mvel:-->
            <!--"matchProvider.calculate(DataSupport.getOriginData,DataSupport.getCompareData,",-->
          <!--args: [-->
            <!--{-->
              <!--label: "比较字段",-->
              <!--type: "calculate",-->
              <!--placeholder: "比较者",-->
              <!--select: true,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->

              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--label: "参照字段",-->
              <!--type: "calculate",-->
              <!--placeholder: "被比较者",-->
              <!--select: true,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "compareData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "5",-->
          <!--mvel: "matchProvider.range(DataSupport.getOriginData,",-->
          <!--args: [-->
            <!--{-->
              <!--values: null,-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->

              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--values: null,-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "6",-->
          <!--mvel: "matchProvider.range(DataSupport.getOriginData,",-->
          <!--args: [-->
            <!--{-->
              <!--values: null,-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--values: null,-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "7",-->
          <!--mvel: "matchProvider.range(DataSupport.getOriginData,'getCLRQ',",-->
          <!--args: [-->
            <!--{-->
              <!--values: null,-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--values: null,-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--}-->
      <!--]-->
    <!--};-->
  <!--},-->
  <!--methods: {-->
    <!---->
    <!--//远程懒加载数据源-->
    <!--remoteMethod(query) {-->
      <!--if (query !== "") {-->
        <!--this.loading = true;-->
        <!--lazyLoadPojo(query).then(response => {-->
          <!--this.loading = false;-->
          <!--let map ={}-->
          <!--this.options = [];-->
          <!--response.data.forEach(el => {-->
            <!--if(!map[el.sourceName]){-->
              <!--this.options.push({label:el.sourceName,options:[{label:el.alias,value:el.table+el.sourceId,sourceId:el.sourceId,driver:el.driver,url:el.url,table:el.table}]})-->
              <!--map[el.sourceName] = el-->
            <!--}else{-->
              <!--for(let i=0;i<this.options.length;i++){-->
                <!--let inner = this.options[i].label-->
                <!--if(el.sourceName==inner){-->
                  <!--this.options[i].options.push({label:el.alias,value:el.table+el.sourceId,sourceId:el.sourceId,driver:el.driver,url:el.url,table:el.table})-->
                <!--}-->
                <!--break-->
              <!--}-->
            <!--} -->
          <!--});-->
        <!--});-->
      <!--} else {-->
        <!--this.options = [];-->
      <!--}-->
    <!--},-->

    <!--// datasource-->
    <!--datasourceInit() {-->
      <!--getDataSourceList("1").then(response => {-->
        <!--response.data.forEach(element => {-->
          <!--this.datasource.push({ value: element.id, label: element.name });-->
        <!--});-->
      <!--});-->
    <!--},-->

    <!--// rangeForm-->
    <!--addLogic() {-->
      <!--if (this.rangeForm.factors.length != 0) {-->
        <!--this.rangeForm.factors =-->
          <!--this.rangeForm.factors +-->
          <!--" " +-->
          <!--"[ " +-->
          <!--this.rangeForm.logic +-->
          <!--" " +-->
          <!--this.rangeForm.value +-->
          <!--" ]";-->
        <!--this.rangeForm.mvel =-->
          <!--this.rangeForm.mvel +-->
          <!--", '" +-->
          <!--this.rangeForm.logic +-->
          <!--"' : " +-->
          <!--"'" +-->
          <!--this.rangeForm.value +-->
          <!--"'";-->
      <!--} else {-->
        <!--this.rangeForm.factors =-->
          <!--"[ " + this.rangeForm.logic + " " + this.rangeForm.value + " ]";-->
        <!--this.rangeForm.mvel =-->
          <!--"'" +-->
          <!--this.rangeForm.field +-->
          <!--"'" +-->
          <!--", [" +-->
          <!--"'" +-->
          <!--this.rangeForm.logic +-->
          <!--"' : " +-->
          <!--"'" +-->
          <!--this.rangeForm.value +-->
          <!--"'";-->
      <!--}-->
    <!--},-->

    <!--// -&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;tree start-->

    <!--getMethod2AllInit() {-->
      <!--getMethod2All().then(response => {-->
        <!--this.treeDoms[1].children.length = 0;-->
        <!--response.data.forEach(el => {-->
          <!--let config = JSON.parse(el.data);-->
          <!--el.editBT = config.editBT;-->
          <!--el.deleteBT = config.deleteBT;-->
          <!--el.addKidsBT = config.addKidsBT;-->
          <!--el.ruleType = el.qualityType;-->
          <!--this.treeDoms[1].children.push(el);-->
        <!--});-->
      <!--});-->
    <!--},-->

    <!--saveRegex() {-->
      <!--this.RegexDialogVisible = false;-->
      <!--let node = this.$refs.tree.getCurrentNode();-->
      <!--let params = {};-->
      <!--params.name = node.label;-->
      <!--params.id = node.methodId;-->
      <!--params.parentId = node.id;-->
      <!--params.data = {-->
        <!--regex: this.currentRegex,-->
        <!--editBT: node.editBT,-->
        <!--deleteBT: node.deleteBT,-->
        <!--addKidsBT: node.addKidsBT-->
      <!--};-->
      <!--params.data = JSON.stringify(params.data);-->
      <!--params.qualityType = node.ruleType;-->
      <!--updateMethod(params).then(response => {-->
        <!--alert(response.data);-->
        <!--this.treeDoms[1].children.length = 0;-->
        <!--this.getMethod2AllInit();-->
      <!--});-->
    <!--},-->

    <!--verifyDel(node, data) {-->
      <!--this.$confirm("将删除此层级, 是否继续?", "提示", {-->
        <!--confirmButtonText: "确定",-->
        <!--cancelButtonText: "取消",-->
        <!--type: "warning"-->
      <!--})-->
        <!--.then(() => {-->
          <!--this.$message({-->
            <!--type: "success",-->
            <!--message: "删除成功!"-->
          <!--});-->
          <!--delMethodByName(data.label).then(() => {-->
            <!--const parent = node.parent;-->
            <!--const children = parent.data.children || parent.data;-->
            <!--const index = children.findIndex(d => d.id === data.id);-->
            <!--children.splice(index, 1);-->
          <!--});-->
        <!--})-->
        <!--.catch(() => {-->
          <!--this.$message({-->
            <!--type: "info",-->
            <!--message: "已取消删除"-->
          <!--});-->
        <!--});-->
    <!--},-->
    <!--filterNode(value, data) {-->
      <!--if (!value) return true;-->
      <!--return data.label.indexOf(value) !== -1;-->
    <!--},-->
    <!--append(newTreeLabel) {-->
      <!--let data = this.$refs.tree.getCurrentNode();-->
      <!--let params = {};-->
      <!--params.name = newTreeLabel;-->
      <!--params.id = data.methodId;-->
      <!--params.parentId = data.id;-->
      <!--params.data = {-->
        <!--regex: null,-->
        <!--editBT: true,-->
        <!--deleteBT: true,-->
        <!--addKidsBT: false-->
      <!--};-->
      <!--params.data = JSON.stringify(params.data);-->
      <!--params.qualityType = data.ruleType;-->
      <!--insertMethod(params).then(response => {-->
        <!--alert(response.data);-->
      <!--});-->
      <!--let dataC = { regex: null };-->
      <!--const newChild = {-->
        <!--id: 0,-->
        <!--label: newTreeLabel,-->
        <!--methodId: data.methodId,-->
        <!--ruleType: data.ruleType,-->
        <!--editBT: true,-->
        <!--deleteBT: true,-->
        <!--addKidsBT: false,-->
        <!--// carryData: dataC,-->
        <!--data: JSON.stringify(dataC),-->
        <!--children: []-->
      <!--};-->
      <!--if (!data.children) {-->
        <!--this.$set(data, "children", []);-->
      <!--}-->
      <!--data.children.push(newChild);-->
      <!--this.addTreeDialogVisible = false;-->
    <!--},-->
    <!--handleNodeClick2(data, node) {-->
      <!--if (!this.addTreeDialogVisible) {-->
        <!--this.currentCategory = data.label;-->
        <!--this.calculateTitle = "《" + data.label + "》";-->
      <!--}-->
      <!--let a = this.$refs.tree.getCurrentNode();-->
      <!--let config = {};-->
      <!--if (a.data) {-->
        <!--config = JSON.parse(a.data);-->
        <!--this.currentRegex = config.regex;-->
      <!--}-->
      <!--this.correctionMethod(a.methodId, config ? config : "");-->
      <!--this.getTableElements();-->
    <!--},-->

    <!--correctionMethod(id, carryData) {-->
      <!--this.currentDes = JSON.parse(-->
        <!--JSON.stringify(this.methodDescritions[id - 1])-->
      <!--);-->
      <!--this.args = this.currentDes.args;-->
      <!--this.args.forEach(element => {-->
        <!--if (element.type == "regex") {-->
          <!--element.values = carryData.regex;-->
        <!--}-->
      <!--});-->
    <!--},-->

    <!--//tree end&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->

    <!--//dataset-->
    <!--openInnerDialog(it, number) {-->
      <!--this.pojo = null;-->
      <!--this.currentIt = it;-->
      <!--if (number == 1) {-->
        <!--this.innerVisible = true;-->
      <!--} else if (number == 3) {-->
        <!--this.innerVisibleSQL = true;-->
      <!--} else {-->
        <!--this.innerVisibleRange = true;-->
      <!--}-->
    <!--},-->

<!--// label:el.alias,value:el.table+el.sourceId,sourceId:el.sourceId,driver:el.driver,url:el.url-->
    <!--getDataFields(object,id){-->
      <!--let promise = new Promise((resolve,rejects)=>{-->
        <!--dataFields(object,id).then((response)=>{-->
          <!--resolve(response.data)-->
        <!--}).catch((error)=>{-->
          <!--rejects()-->
        <!--})-->
      <!--})-->
      <!--return promise-->
    <!--},-->

    <!--closeInnerDialog(pojo, number) {-->
      <!--switch (number) {-->
        <!--case 1:-->
          <!--this.currentIt.linkDataset.id = pojo.sourceId;-->
          <!--this.currentIt.linkDataset.source = {};-->
          <!--this.currentIt.linkDataset.source.url = pojo.url;-->
          <!--this.currentIt.linkDataset.source.driver = pojo.driver;-->
          <!--this.currentIt.linkDataset.label = pojo.label;-->
          <!--this.getDataFields(pojo.table,pojo.sourceId).then((response)=>{-->
            <!--this.currentIt.linkDataset.sql=response-->
          <!--})-->
          <!--readCols({dataobject:pojo.table,datasource:pojo.sourceId}).then(response => {-->
            <!--this.currentIt.pojoElements.length = 0;-->
            <!--response.data.forEach(element => {-->
              <!--let a = {-->
                <!--col:element.col,-->
                <!--alias:element.alias,-->
                <!--classValue:element.value,-->
                <!--classLabel:element.label,-->
                <!--natural:true,-->
                <!--setter:element.setter,-->
                <!--getter:element.getter-->
              <!--};-->
              <!--this.currentIt.pojoElements.push(a);-->
            <!--});-->
            <!--this.innerVisible = false;-->
          <!--});-->
          <!--break;-->
        <!--case 2:-->
          <!--this.getDataFields(pojo.table,pojo.sourceId).then((response)=>{-->
            <!--this.currentDes.args[0].linkDataset.sql= response-->
          <!--})-->
          <!--this.currentDes.args[0].linkDataset.id = pojo.sourceId;-->
          <!--this.currentDes.args[0].linkDataset.label = pojo.label;-->
          <!--this.currentDes.args[0].linkDataset.source ={}-->
          <!--this.currentDes.args[0].linkDataset.source.url= pojo.url,-->
          <!--this.currentDes.args[0].linkDataset.source.driver = pojo.driver-->
          <!--this.rangeForm.pojo.value = pojo.datasource;-->
          <!--this.rangeForm.pojo.label = pojo.name;-->
          <!--readCols({dataobject:pojo.table,datasource:pojo.sourceId}).then(response => {-->
            <!--this.rangeForm.pojoElements.length = 0;-->
            <!--response.data.forEach(element => {-->
              <!--let a = {-->
                <!--col:element.col,-->
                <!--alias:element.alias,-->
                <!--classValue:element.value,-->
                <!--classLabel:element.label,-->
                <!--natural:true,-->
                <!--setter:element.setter,-->
                <!--getter:element.getter-->
              <!--};-->
              <!--this.rangeForm.pojoElements.push(a);-->
            <!--});-->
            <!--this.innerVisibleRange = false;-->
          <!--});-->
          <!--break;-->
        <!--case 3:-->
          <!--this.currentDes.args[0].linkDataset.id = pojo.value;-->
          <!--this.currentDes.args[0].linkDataset.label = pojo.label;-->
          <!--this.sqlForm.pojo.value = pojo.value;-->
          <!--this.sqlForm.pojo.label = pojo.label;-->
          <!--readPojoById(this.sqlForm.pojo.value).then(response => {-->
            <!--let config = JSON.parse(response.data.data);-->
            <!--config.forEach(element => {-->
              <!--let a = {-->
                <!--label: element.alias,-->
                <!--value: element.getter-->
              <!--};-->
            <!--});-->
            <!--this.innerVisibleSQL = false;-->
          <!--});-->
          <!--break;-->
      <!--}-->
      <!--if (number == 1) {-->
      <!--} else {-->
      <!--}-->
    <!--},-->

    <!--getPojoListInit() {-->
      <!--getCategoryList("1").then(response => {-->
        <!--response.data.forEach(element => {-->
          <!--if (element.id !== 0) {-->
            <!--let a = { label: element.name, value: element.id };-->
            <!--this.pojoSet.push(a);-->
          <!--}-->
        <!--});-->
      <!--});-->
    <!--},-->
    <!--//  rule-->
    <!--addRule() {-->
      <!--let node = this.$refs.tree.getCurrentNode();-->
      <!--if (node.methodId == "5" || node.methodId == "6") {-->
        <!--this.rangeDialogVisible = true;-->
        <!--if (node.methodId == "5") {-->
          <!--this.rangeForm.logic = null;-->
          <!--this.rangeForm.value = null;-->
          <!--(this.rangeForm.pojo = {-->
            <!--label: "关联属性集",-->
            <!--value: null-->
          <!--}),-->
            <!--(this.rangeForm.factors = []),-->
            <!--(this.rangeForm.mvel = null),-->
            <!--(this.rangeType = "number");-->
          <!--this.rangePlaceHandler = "输入值域";-->
        <!--} else {-->
          <!--this.rangeType = "Date";-->
          <!--this.rangePlaceHandler = "日期格式例如:2019-01-01";-->
        <!--}-->
      <!--} else if (node.methodId == "7") {-->
        <!--this.sqlDialogVisible = true;-->
      <!--} else {-->
        <!--this.instanceRuleDialogVisible = true;-->
      <!--}-->
    <!--},-->

    <!--saveMethod() {-->
      <!--let params = [];-->
      <!--//通过MethodId 判断属于哪个-->
      <!--let node = this.$refs.tree.getCurrentNode();-->
      <!--switch (node.methodId) {-->
        <!--case 1:-->
          <!--let firstArg = "[";-->
          <!--this.currentDes.args[0].values.forEach(el => {-->
            <!--firstArg = firstArg + "'" + el + "'" + ",";-->
          <!--});-->
          <!--firstArg = firstArg + "]";-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel +-->
            <!--firstArg +-->
            <!--"," +-->
            <!--this.currentDes.args[1].values +-->
            <!--")";-->
          <!--break;-->
        <!--case "2":-->
          <!--this.currentDes.regex = this.currentDes.args[0].values;-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel + "'" + this.currentDes.args[1].values + "' )";-->
          <!--break;-->
        <!--case 3:-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel +-->
            <!--"'" +-->
            <!--this.currentDes.args[0].values +-->
            <!--"'" +-->
            <!--",";-->
          <!--this.currentDes.mvel = this.currentDes.mvel + "' ' , 'isNull' )";-->
          <!--break;-->
        <!--case 4:-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel +-->
            <!--"'" +-->
            <!--this.currentDes.args[0].values +-->
            <!--"'" +-->
            <!--",";-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel +-->
            <!--"'" +-->
            <!--this.currentDes.args[1].values +-->
            <!--"'" +-->
            <!--",";-->
          <!--this.currentDes.mvel = this.currentDes.mvel + " 'include' )";-->
          <!--break;-->
        <!--case "5":-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel + this.rangeForm.mvel + "], 'number' )";-->
          <!--break;-->
        <!--case "6":-->
          <!--this.currentDes.mvel =-->
            <!--this.currentDes.mvel + this.rangeForm.mvel + "], 'Date' )";-->
          <!--break;-->
        <!--case "7":-->
          <!--this.currentDes.SQL = this.sqlForm.sql;-->
          <!--this.currentDes.launcherType = "sql";-->
          <!--this.currentDes.sourceId = this.sqlForm.source.value;-->
          <!--this.currentDes.sourceName = this.sqlForm.source.label;-->
          <!--break;-->
      <!--}-->

      <!--let pojos = [];-->
      <!--this.currentDes.args.forEach(value => {-->
        <!--if (value.linkDataset && value.linkDataset.id !== null) {-->
          <!--pojos.push({-->
            <!--datasource:value.linkDataset.source,-->
            <!--dataJson:value.pojoElements,-->
            <!--dataSql:value.linkDataset.sql,-->
            <!--dataName: value.linkDataset.dataName-->
          <!--});-->
        <!--}-->
      <!--});-->
      <!--this.currentDes.params = params;-->
      <!--let qualityConfig = {-->
        <!--mvel: this.currentDes.mvel,-->
        <!--pojo: pojos,-->
        <!--ruleType: node.ruleType,-->
        <!--detectionType: node.label,-->
        <!--regex: this.currentDes.regex ? this.currentDes.regex : "",-->
        <!--launcherType: this.currentDes.launcherType-->
          <!--? this.currentDes.launcherType-->
          <!--: null,-->
        <!--SQL: this.currentDes.SQL ? this.currentDes.SQL : null,-->
        <!--sourceId: this.currentDes.sourceId ? this.currentDes.sourceId : null,-->
        <!--sourceName: this.currentDes.sourceName-->
          <!--? this.currentDes.sourceName-->
          <!--: null-->
      <!--};-->
      <!--let datas = {-->
        <!--userId: "1",-->
        <!--data: {-->
          <!--name: this.newRuleName,-->
          <!--category: this.currentCategory,-->
          <!--time: new Date().format("yyyy-MM-dd hh:mm:ss"),-->
          <!--config: qualityConfig-->
        <!--}-->
      <!--};-->
      <!--save(datas).then(() => {-->
        <!--this.tableData2.length = 0;-->
        <!--this.getTableElements();-->
        <!--this.instanceRuleDialogVisible = false;-->
        <!--this.rangeDialogVisible = false;-->
        <!--this.sqlDialogVisible = false;-->
      <!--});-->
    <!--},-->

    <!--//table-->
    <!--getTableElements() {-->
      <!--this.tableData2.length = 0;-->
      <!--getCalculateByCategory(this.currentCategory)-->
        <!--.then(response => {-->
          <!--response.data.forEach(element => {-->
            <!--let config = JSON.parse(element.data);-->
            <!--let tableName = [];-->
            <!--if (config.pojo instanceof Array) {-->
              <!--config.pojo.forEach(el => {-->
                <!--tableName.push(el.label);-->
              <!--});-->
            <!--} else {-->
              <!--tableName = config.pojo.label;-->
            <!--}-->
            <!--this.tableData2.push({-->
              <!--name: element.name,-->
              <!--time: element.time,-->
              <!--id: element.id,-->
              <!--pojo: config.pojo,-->
              <!--effect: config.ruleType,-->
              <!--mvel: config.mvel,-->
              <!--regex: config.regex,-->
              <!--detectionType: config.detectionType,-->
              <!--tableName: JSON.stringify(tableName),-->
              <!--sourceName: config.sourceName ? config.sourceName : null,-->
              <!--show: true-->
            <!--});-->
          <!--});-->
          <!--this.currentTotalRule = this.tableData2.length;-->
        <!--})-->
        <!--.catch(() => {});-->
    <!--},-->

    <!--filterTable(keyword) {-->
      <!--if (!keyword || keyword == "") {-->
        <!--this.tableData2.length = 0;-->
        <!--this.getAllRules();-->
      <!--} else {-->
        <!--getQualityAll().then(response => {-->
          <!--this.tableData2.length = 0;-->
          <!--response.data.forEach(element => {-->
            <!--let config = JSON.parse(element.data);-->
            <!--let tableName = [];-->
            <!--if (config.pojo instanceof Array) {-->
              <!--config.pojo.forEach(el => {-->
                <!--tableName.push(el.label);-->
              <!--});-->
            <!--} else {-->
              <!--tableName = config.pojo.label;-->
            <!--}-->
            <!--this.tableData2.push({-->
              <!--name: element.name,-->
              <!--time: element.time,-->
              <!--id: element.id,-->
              <!--pojo: config.pojo,-->
              <!--mvel: config.mvel,-->
              <!--effect: config.ruleType,-->
              <!--regex: config.regex,-->
              <!--detectionType: config.detectionType,-->
              <!--tableName: JSON.stringify(tableName),-->
              <!--sourceName: config.sourceName ? config.sourceName : null,-->
              <!--show: true-->
            <!--});-->
          <!--});-->
          <!--for (let i = this.tableData2.length - 1; i >= 0; i&#45;&#45;) {-->
            <!--if (-->
              <!--this.tableData2[i].name.indexOf(keyword) < 0 &&-->
              <!--this.tableData2[i].tableName.indexOf(keyword) < 0 &&-->
              <!--this.tableData2[i].effect.indexOf(keyword) < 0 &&-->
              <!--this.tableData2[i].detectionType.indexOf(keyword) < 0-->
            <!--) {-->
              <!--this.tableData2.splice(i, 1);-->
            <!--}-->
          <!--}-->
          <!--this.currentTotalRule = this.tableData2.length;-->
        <!--});-->
      <!--}-->
    <!--},-->
    <!--sortByDate() {-->
      <!--this.tableData2.sort(function(a, b) {-->
        <!--return a.time < b.time ? 1 : -1;-->
      <!--});-->
    <!--},-->

    <!--//对页面所有规则的过滤   对table进行过滤 过滤名字、作用表、规则类型。-->

    <!--//rule actions-->
    <!--fire(o) {-->
      <!--this.wids.length = 0;-->
      <!--this.widCount = null;-->
      <!--this.loading = true;-->
      <!--let ruleJson = {};-->
      <!--ruleJson.MVELExpression = [];-->
      <!--ruleJson.MVELExpression.push({-->
        <!--name: o.name,-->
        <!--description: "质量检测",-->
        <!--priority: 1,-->
        <!--condition: "1==1",-->
        <!--action: "DataSupport.setInterimMap(" + o.mvel + ");"-->
      <!--});-->
      <!--let params = { id: o.id };-->
      <!--fireById(params).then(response => {-->
        <!--if (response.data.length > 501) {-->
          <!--for (let i = 0; i < 501; i++) {-->
            <!--this.wids.push(response.data[i]);-->
          <!--}-->
        <!--} else {-->
          <!--this.wids = response.data;-->
        <!--}-->
        <!--this.widCount = "WID共计条数：" + response.data.length;-->
        <!--this.loading = false;-->
      <!--});-->
    <!--},-->
    <!--delUnnatural(index, id) {-->
      <!--this.$confirm("将删除此规则, 是否继续?", "提示", {-->
        <!--confirmButtonText: "确定",-->
        <!--cancelButtonText: "取消",-->
        <!--type: "warning"-->
      <!--})-->
        <!--.then(() => {-->
          <!--this.$message({-->
            <!--type: "success",-->
            <!--message: "删除成功!"-->
          <!--});-->
          <!--this.tableData2.splice(index, 1);-->
          <!--del(id).then(() => {});-->
        <!--})-->
        <!--.catch(() => {-->
          <!--this.$message({-->
            <!--type: "info",-->
            <!--message: "已取消删除"-->
          <!--});-->
        <!--});-->
    <!--},-->
    <!--getAllRules() {-->
      <!--getQualityAll().then(response => {-->
        <!--response.data.forEach(element => {-->
          <!--let config = JSON.parse(element.data);-->
          <!--let tableName = [];-->
          <!--if (config.pojo instanceof Array) {-->
            <!--config.pojo.forEach(el => {-->
              <!--tableName.push(el.label);-->
            <!--});-->
          <!--} else {-->
            <!--tableName = config.pojo.label;-->
          <!--}-->
          <!--this.tableData2.push({-->
            <!--name: element.name,-->
            <!--time: element.time,-->
            <!--id: element.id,-->
            <!--pojo: config.pojo,-->
            <!--mvel: config.mvel,-->
            <!--effect: config.ruleType,-->
            <!--regex: config.regex,-->
            <!--detectionType: config.detectionType,-->
            <!--tableName: JSON.stringify(tableName),-->
            <!--sourceName: config.sourceName ? config.sourceName : null,-->
            <!--show: true-->
          <!--});-->
        <!--});-->
        <!--this.currentTotalRule = this.tableData2.length;-->
      <!--});-->
    <!--}-->
  <!--},-->

  <!--mounted: function() {-->
    <!--this.getMethod2AllInit();-->
    <!--this.getPojoListInit();-->
    <!--this.getAllRules();-->
    <!--this.datasourceInit();-->
  <!--}-->
<!--};-->
<!--</script>-->



<!--<style lang="scss" >-->
<!--.board-column-content {-->
  <!--height: auto;-->
  <!--overflow: hidden;-->
  <!--border: 10px solid transparent;-->
  <!--min-height: 60px;-->
  <!--display: flex;-->
  <!--justify-content: flex-start;-->
  <!--flex-direction: column;-->
  <!--align-items: center;-->
<!--}-->
<!--.el-table .warning-row {-->
  <!--background: oldlace;-->
<!--}-->

<!--.el-table .success-row {-->
  <!--background: #f0f9eb;-->
<!--}-->

<!--// .el-tabs__item {-->
<!--//   padding: 20px;-->
<!--// }-->

<!--.dashboard {-->
  <!--&-container {-->
    <!--margin: 30px;-->
    <!--height: 826px;-->
  <!--}-->
  <!--&-text {-->
    <!--font-size: 30px;-->
    <!--line-height: 46px;-->
  <!--}-->
<!--}-->
<!--.el-header {-->
  <!--background-color: #b3c0d1;-->
  <!--color: #333;-->
  <!--line-height: 60px;-->
<!--}-->

<!--.el-aside {-->
  <!--color: #333;-->
<!--}-->

<!--.el-row {-->
  <!--margin-bottom: 20px;-->
  <!--&:last-child {-->
    <!--margin-bottom: 0;-->
  <!--}-->
<!--}-->
<!--.el-col {-->
  <!--border-radius: 4px;-->
<!--}-->
<!--.bg-purple-dark {-->
  <!--background: #99a9bf;-->
<!--}-->
<!--.bg-purple {-->
  <!--background: #d3dce6;-->
<!--}-->
<!--.bg-purple-light {-->
  <!--background: #e5e9f2;-->
<!--}-->
<!--.grid-content {-->
  <!--border-radius: 4px;-->
  <!--min-height: 36px;-->
  <!--border-right: 2px dashed #eee;-->
<!--}-->
<!--.row-bg {-->
  <!--padding: 10px 0;-->
  <!--background-color: #f9fafc;-->
<!--}-->

<!--.cutline {-->
  <!--position: relative;-->
  <!--left: -15px;-->
  <!--top: -15px;-->
<!--}-->
<!--.cardrow::-webkit-scrollbar {-->
  <!--display: none;-->
<!--}-->
<!--.wids::-webkit-scrollbar {-->
  <!--display: none;-->
<!--}-->
<!--.textarea {-->
  <!--min-height: 260px;-->
<!--}-->
<!--.board-item {-->
  <!--cursor: pointer;-->
  <!--width: 100%;-->
  <!--height: 32px;-->
  <!--margin: 5px 0;-->
  <!--background-color: #ecf5ff;-->
  <!--text-align: left;-->
  <!--line-height: 28px;-->
  <!--padding: 5px 10px;-->
  <!--box-sizing: border-box;-->
  <!--box-shadow: 0px 1px 3px 0 rgba(0, 0, 0, 0.2);-->
<!--}-->
<!--.custom-tree-node {-->
  <!--flex: 1;-->
  <!--display: flex;-->
  <!--align-items: center;-->
  <!--justify-content: space-between;-->
  <!--font-size: 14px;-->
  <!--padding-right: 8px;-->
<!--}-->

<!--.el-transfer-panel {-->
  <!--max-width: 30%;-->
  <!--height: 580px;-->
<!--}-->
<!--.el-transfer-panel__list.is-filterable::-webkit-scrollbar {-->
  <!--width: 0 !important;-->
<!--}-->
<!--.el-transfer-panel__list.is-filterable {-->
  <!--height: 480px;-->
<!--}-->
<!--.el-table__body-wrapper::-webkit-scrollbar {-->
  <!--width: 0 !important;-->
<!--}-->
<!--.el-transfer-panel .el-transfer-panel__header .el-checkbox .el-checkbox__label {-->
  <!--font-size: 10px;-->
<!--}-->
<!--.time {-->
  <!--font-size: 13px;-->
  <!--color: #999;-->
<!--}-->

<!--.bottom {-->
  <!--margin-top: 13px;-->
  <!--line-height: 12px;-->
<!--}-->

<!--.button {-->
  <!--padding: 0;-->
  <!--float: right;-->
<!--}-->

<!--.image {-->
  <!--width: 100%;-->
  <!--display: block;-->
<!--}-->

<!--.clearfix:before,-->
<!--.clearfix:after {-->
  <!--display: table;-->
  <!--content: "";-->
<!--}-->

<!--.clearfix:after {-->
  <!--clear: both;-->
<!--}-->
<!--</style>-->
